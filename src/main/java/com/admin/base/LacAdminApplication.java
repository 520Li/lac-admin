package com.admin.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("com.admin.base.dao*")
public class LacAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(LacAdminApplication.class, args);
    }

}
