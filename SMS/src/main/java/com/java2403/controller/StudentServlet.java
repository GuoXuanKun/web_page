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
        //获得 参数 op
        String op  =     request.getParameter("op");
        System.out.println("op:"+op);
        // 根据op值 调用相应的方法（执行相应的操作）
        if("queryAllStudent".equals(op)){ //查询全部

            queryAllStudent(request,response);

        }else if("login".equals(op)){    // 登录
            login(request,response);
        } else if ("queryMyInfo".equals(op)) {
            queryMyInfo(request,response);
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


    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sno_str   = request.getParameter("sno");
        int sno  = Integer.parseInt(sno_str);// 判断是否为 数字...
        String password  = request.getParameter("password");

        StudentDao studentDao  = new StudentDao();
        boolean flag  = studentDao.login(sno,password);
        if(flag){
            request.setAttribute("sno",sno);
            // 成功跳转到 欢迎界面
            request.getRequestDispatcher("main.jsp").forward(request,response);


        }else{
            // 携带相关消息过去
            request.setAttribute("msg","学号或密码错误,请重新登录");
            // 失败，回到登录界面，重新登录
            request.getRequestDispatcher("login.jsp").forward(request,response);

        }

    }

    protected void queryMyInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //
        String sno_str = request.getParameter("sno");
        int sno = Integer.parseInt(sno_str);
        StudentDao studentDao = new StudentDao();
        Student my = studentDao.queryMyInfo(sno);
        request.setAttribute("my",my);
        request.getRequestDispatcher("queryMyInfo.jsp").forward(request,response);

    }


}
