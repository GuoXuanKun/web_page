package com.java2403.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "UploadServlet", value = "/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        System.out.println(request.getParameter("username"));


       Part part  =  request.getPart("myFile");
       //获得提交时的文件的文件名（原始名称）
     String  fileName  =   part.getSubmittedFileName();
        System.out.println(fileName);
//        InputStream is   = part.getInputStream();导入导出的功能会用上

            // 获得当前工程 所在的服务器 的真实路径
//        System.out.println(request.getServletContext().getRealPath("/"));
        // 获得当前工程 所在的服务器 的真实路径 的 叫  upload 的文件夹
        String  realPath  =   request.getServletContext().getRealPath("/upload");
        // 判断，路径是否存在，不存在就创建一个i路径
        File file  = new File(realPath);
        if(!file.exists()){
            file.mkdirs();
        }

        // new File("xxx.txt"); file.xxxxx
        part.write(realPath+"/"+fileName);// xxxx/abc.exe
        // 把文件写在本地路径（IO流）
        response.getWriter().println("上传完毕");


    }
}
