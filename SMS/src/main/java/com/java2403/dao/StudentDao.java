package com.java2403.dao;

import com.java2403.entity.Student;
import com.java2403.util.JDBCUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    // 查询所有
    public static void queryAll() throws SQLException {
        String queryAll = "select * from t_student";
        ResultSet resultSet = JDBCUtils.doQuery(queryAll);
        List<Student> slist = new ArrayList<>();
        while (resultSet.next()) {
            Student student = new Student();
            student.setSno(resultSet.getInt("sno"));
            student.setSname(resultSet.getString("sname"));
            student.setPassword(resultSet.getString("password"));
            student.setSex(resultSet.getString("sex"));
            student.setAge(resultSet.getInt("age"));
            student.setBirthday(resultSet.getDate("birthday"));
            slist.add(student);
        }
        System.out.println(slist);
        JDBCUtils.doClose(resultSet);
    }

    // 按学号查询
    public static void queryBySno() throws SQLException {
        String query = "select * from t_student where sno = ?" ;
        ResultSet resultSet = JDBCUtils.doQuery(query,001);
        List<Student> slist = new ArrayList<>();
        while (resultSet.next()) {
            Student student = new Student();
            student.setSno(resultSet.getInt("sno"));
            student.setSname(resultSet.getString("sname"));
            student.setPassword(resultSet.getString("password"));
            student.setSex(resultSet.getString("sex"));
            student.setAge(resultSet.getInt("age"));
            student.setBirthday(resultSet.getDate("birthday"));
            slist.add(student);
        }
        System.out.println(slist);
        JDBCUtils.doClose(resultSet);
    }

    // 按名字模糊查询
    public static void queryBySname() throws SQLException {
        String query = "select * from t_student where sname like concat('%',?,'%') " ;
        ResultSet resultSet = JDBCUtils.doQuery(query,"白");
        List<Student> slist = new ArrayList<>();
        while (resultSet.next()) {
            Student student = new Student();
            student.setSno(resultSet.getInt("sno"));
            student.setSname(resultSet.getString("sname"));
            student.setPassword(resultSet.getString("password"));
            student.setSex(resultSet.getString("sex"));
            student.setAge(resultSet.getInt("age"));
            student.setBirthday(resultSet.getDate("birthday"));
            slist.add(student);
        }
        System.out.println(slist);
        JDBCUtils.doClose(resultSet);
    }
    // 按学号更新
    public static void updateBySno() throws SQLException {
        String query = "update t_student set sname = ? where sno = ? " ;
        int resultSet = JDBCUtils.doUpdate(query,"白",1);


        System.out.println(resultSet);

    }
}
