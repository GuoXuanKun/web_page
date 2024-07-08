package com.java2403.listener;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class DemoListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public DemoListener() {
        System.out.println("DemoListener 无参构造");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("上下文 application对象的初始化时调用");
        // 可以把数据 从 数据库中 读取回来
}

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("上下文 application对象的销毁时调用");
        // 可以把数据 保存到 数据库中

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {

        System.out.println("上下文 session对象的创建时调用");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        System.out.println(" session对象的销毁时调用");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {

        System.out.println("属性的添加时调用");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {

        System.out.println("属性被移除时调用");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {

        System.out.println("属性被替换时调用");
    }
}
