package com.java2403.util;

import com.java2403.entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo03 {


    public static void main(String[] args) throws  Exception{

        // 1 加载驱动
        //
        Class.forName("com.mysql.cj.jdbc.Driver");

        //  2 建立链接： 通过驱动管理(管家)， 获得一个 连接对象（连接者）
        // 三个参数：地址（连接地址 带上数据库名 ） 用户名  密码
      Connection  conn  =  DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","root");


        // 3 获得一个 执行 语句 对象  参数为 sql语句，切记 查询中 尽量不要用 *  ，不方便维护
      PreparedStatement psm  = conn.prepareStatement("select sno,sname,password,sex,age from t_student");
        //  执行语句(或者先 加入 参数)
        ResultSet rs  =  psm.executeQuery();// 查询，获得结果集
        //psm.executeUpdate()// 更新，获得执行行数
        // 4 处理结果(集合)、
        List<Student> slist   = new ArrayList<Student>();
        while(rs.next()){
            Student stu   = new Student();
            stu.setSno(rs.getInt("sno"));
            stu.setSname(rs.getString("sname"));
            stu.setPassword(rs.getString("password"));
            stu.setSex(rs.getString("sex"));
            stu.setAge(rs.getInt("age"));
            slist.add(stu);
        }

        System.out.println(slist);


        // 5 关闭资源
        rs.close();
        psm.close();
        conn.close();


    }



}
