package com.admin.base.config;

import com.admin.base.domain.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * <p>
 * 配置应用的MVC全局特性
 *
 * @author lac
 * @version 1.0
 * @date 2019/8/25 0025 - 19:40
 */
@Configuration
public class MvcConfigurer implements WebMvcConfigurer {

    //格式化
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
        //registry.addFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    //拦截器
    /*
    通过 addInterceptors方法可以设置多个拦截器，
    比如对特定的URI设定拦截器检查用户是否登录，
    打印处理用户请求耗费的时间等。
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //增加一个拦截器，检查会话
        registry.addInterceptor(new SessionHandlerInterceptor())
                .addPathPatterns("/*/**")
                .addPathPatterns("/")
                .excludePathPatterns(Arrays.asList("/login.do", "/layui/**", "/login/**", "/login2/**", "/assets/**", "/module/**"));
    }

    //配置静态资源映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/layui/**").addResourceLocations("classpath:/static/layui/");
        registry.addResourceHandler("/login/**").addResourceLocations("classpath:/static/login/");
        registry.addResourceHandler("/login2/**").addResourceLocations("classpath:/static/login2/");
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/static/assets/");
        registry.addResourceHandler("/module/**").addResourceLocations("classpath:/static/module/");

    }

    //跨域访问配置
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
        /*registry.addMapping("/api/**")
                .allowedOrigins("http://domain2.com")
                .allowedMethods("POST", "GET");*/
    }

    //uri到视图的映射
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //系统登录页面
        registry.addViewController("/login").setViewName("/login.html");
    }


    /**
     * 自定义session拦截器
     */
    class SessionHandlerInterceptor implements HandlerInterceptor {

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            User user = (User) request.getSession().getAttribute("login_user");
            if (user == null) {
                response.sendRedirect("/login");
                return false;
            }
            return true;
        }

        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
            //Controller方法处理完毕后，调用此方法
        }

        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
            // 页面渲染完毕后调用此方法，通常用来清除某些资源使用，类似Java语法的finally 作用。
        }
    }

}


