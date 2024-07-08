package com.java2403.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext application  =  sce.getServletContext();// 获得上下文对象
        // 1 从数据库中获得 访问人数

        // a 如果有人数（直接使用）
        // 比如从数据库中获得到 visitCount=60;


        // b 如果是空的，则 直接 添加一个初始化数据 application.setAttribute("visitCount",0);
        //visitCount=0;

        //将数据保存到上下文中
        //application.setAttribute("visitCount",visitCount);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        // 先 通过 上下文对象 application获得 visitCount

        // 将访问人数 insert 或 update 到 数据库中（设计一张表  访问人数表  就一个字段 人数字段 10  ）
        // 或则表 这么设计  序列号（主键）  访问人数 数据更新时间




    }
}
