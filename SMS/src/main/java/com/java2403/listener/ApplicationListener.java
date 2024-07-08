package com.java2403.listener;

import com.java2403.dao.AdminDao;

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
        // 1 从数据库中获得 访问人数
        AdminDao adminDao = new AdminDao();
        int visitCount = adminDao.getVisitCount();

        // 2 将数据放到 application 对象中
        // 获得 application 对象
        ServletContext application = sce.getServletContext();
        application.setAttribute("visitCount",visitCount);

        System.out.println("访问记录获得成功");


    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        // 1 先 通过 上下文对象 application获得 visitCount
        ServletContext application = sce.getServletContext();
        int visitCount = (Integer) application.getAttribute("visitCount");

        // 2 将访问人数 insert 或 update 到 数据库中（设计一张表  访问人数表  就一个字段 人数字段 10  ）
        AdminDao adminDao = new AdminDao();
        boolean flag = adminDao.saveVisitCount(visitCount);
        if(flag){
            System.out.println("访问记录保存成功");
        }else{
            System.out.println("访问记录保存失败");
        }


    }
}
