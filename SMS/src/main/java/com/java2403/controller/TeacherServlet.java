package com.java2403.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "TeacherServlet", value = "/teacher")
public class TeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String op   =  request.getParameter("op");

        System.out.println("op:"+op);

        if("login".equals(op)){

            System.out.println("登录操作");
           HttpSession session  =  request.getSession();
            session.setAttribute("tno","666");


        }else if("queryMyInfo".equals(op)){

            System.out.println("查看个人信息");



        }






    }
}
