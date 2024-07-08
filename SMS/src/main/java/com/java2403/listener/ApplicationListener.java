package com.java2403.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class ApplicationListener implements ServletContextListener {

    public ApplicationListener() {

        System.out.println("ApplicationListener 无参构造");
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

}
