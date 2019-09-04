/* 自定义组件 */
layui.define(function (exports) {
    var obj = {
        hello: function (str) {
            alert("hello world");
        }
    }

    exports('mymod', obj);
})