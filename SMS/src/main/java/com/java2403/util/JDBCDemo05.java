package com.java2403.util;

import com.java2403.entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCDemo05 {

    public static void main(String[] args)  throws  Exception{



        // 1 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2 获得链接语句对象
        Connection conn  =  DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","root");
        // 3 获得执行语句对象
        PreparedStatement psm =  conn.prepareStatement("insert into t_student(sname,password,sex,age)values(?,?,?,?)");
        // 设置 传值
        psm.setString(1,"刘德华");
        psm.setString(2,"123");
        psm.setString(3,"男");
        psm.setInt(4,50);
        int count   = psm.executeUpdate();
        System.out.println(count>0?"添加成功":"添加失败");




//        PreparedStatement psm =  conn.prepareStatement("update t_student set sname =?,password=?,sex=?,age=? where sno  = ?");
//        // 切记：顺序一定要按照 sql语句中的占位 来写
//        //  psm.setInt(1,stu.getSno());
//        psm.setString(1,"张曼玉");
//        psm.setString(2,"123");
//        psm.setString(3,"男");
//        psm.setInt(4,40);
//        psm.setInt(5,108);
//
//        // 4 执行语句，得到处理
//        int count   = psm.executeUpdate();
//        System.out.println(count>0?"修改成功":"修改失败");

        // 物理删除（直接删掉） 逻辑删除（设置一个状态，update 更新 ，然后修改 1 正常  0 退学 ）
//        PreparedStatement psm =  conn.prepareStatement("delete from t_student where sno  = ?");
        psm.setInt(1,107);


      // 4 执行语句，得到处理
//        int count   = psm.executeUpdate();
//        System.out.println(count>0?"删除成功":"删除失败");



        // 5 关闭资源
        psm.close();
        conn.close();

    }

}
