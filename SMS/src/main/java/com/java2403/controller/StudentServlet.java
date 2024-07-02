package com.java2403.controller;

import com.java2403.dao.StudentDao;
import com.java2403.entity.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 中文处理
        request.setCharacterEncoding("utf-8");


        String op  =     request.getParameter("op");

        if("queryAllStudent".equals(op)){ //查询全部
            queryAllStudent(request,response);

        }else if("login".equals(op)){    // 登录
//                login();
        }


            //注册
            // 修改
            // 删除





    }

    protected void queryAllStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        //
        StudentDao studentDao  = new StudentDao();
        List<Student> slist   =  studentDao.queryAllStudent();
        // 把数据放在属性中（行李箱中）属性名  叫 slist 后面的人就可以直接拿了
        request.setAttribute("slist",slist);
        // 跳转到显示页面
        request.getRequestDispatcher("queryAllStudent.jsp").forward(request,response);

    }





}
