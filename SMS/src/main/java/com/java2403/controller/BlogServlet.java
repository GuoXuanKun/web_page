package com.java2403.controller;


import com.java2403.dao.BlogDao;
import com.java2403.entity.Blog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BlogServlet", value = "/blog/manage")
public class BlogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String op  = request.getParameter("op");

        if("addBlog".equals(op)){
            addBlog(request,response);


        }else if("queryAllBlog".equals(op)){
            queryAllBlog(request,response);
        }else if("queryBlogById".equals(op)){
            queryBlogById(request,response);
        }
        else if("editBlog".equals(op)){
            editBlog(request,response);
        }




    }

    protected void addBlog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title  = request.getParameter("title");
        String content  = request.getParameter("content");

        BlogDao blogDao  = new BlogDao();
        boolean flag  =  blogDao.addBlog(title,content);

        // 成功失败 各种判断（你们来做）
        response.sendRedirect("manage?op=queryAllBlog");




    }

    protected void queryAllBlog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BlogDao blogDao  = new BlogDao();
        List<Blog> blogList =  blogDao.queryAllBlog();
        request.setAttribute("blogList",blogList);
        request.getRequestDispatcher("queryAllBlog.jsp").forward(request,response);


    }

    protected void queryBlogById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      String blogId_str  =  request.getParameter("blogId");
        int blogId  = Integer.parseInt(blogId_str);
        BlogDao blogDao  = new BlogDao();


        Blog blog =  blogDao.queryBlogById(blogId);
        request.setAttribute("blog",blog);
        request.getRequestDispatcher("queryBlogById.jsp").forward(request,response);


    }


    protected void editBlog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 跳转到编辑界面
        String blogId_str  =  request.getParameter("blogId");
        int blogId  = Integer.parseInt(blogId_str);
        BlogDao blogDao  = new BlogDao();


        Blog blog =  blogDao.queryBlogById(blogId);
        request.setAttribute("blog",blog);

        request.getRequestDispatcher("editBlog.jsp").forward(request,response);


    }



}



