package com.java2403.controller;

import com.java2403.dao.BLogDao;
import com.java2403.dao.BlogDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TestUeditorServlet", value = "/TestUeditorServlet")
public class TestUeditorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title  = request.getParameter("title");
        String content  = request.getParameter("content");

        BlogDao blogDao = new BlogDao();
        boolean flag  =  blogDao.addBlog(title,content);


        System.out.println(flag );



    }
}
