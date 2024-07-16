package com.java2403.controller;

import com.java2403.util.EmailUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestEmailServlet", value = "/TestEmailServlet")
public class TestEmailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String rnum  = request.getParameter("rnum");
       String youEmail =  request.getParameter("youEmail");


        boolean flag  =  EmailUtils.sendEmail("XXX网站的验证码","校验验证码是："+rnum,youEmail);

       PrintWriter out  = response.getWriter();
        out.println(flag);
        out.flush();
        out.close();






    }
}
