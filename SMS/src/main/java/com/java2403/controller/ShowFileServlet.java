package com.java2403.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowFileServlet", value = "/ShowFileServlet")
public class ShowFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


       String readPath  = request.getServletContext().getRealPath("/upload");

        File readPathFile = new File(readPath);

        List<String> fileList  =new ArrayList<>();

        if(readPathFile.isDirectory()){

          File[] files  =   readPathFile.listFiles();

          for(File f: files){
              fileList.add(f.getName());
          }

            request.setAttribute("fileList",fileList);
            request.getRequestDispatcher("showFile.jsp").forward(request,response);

        }




    }
}
