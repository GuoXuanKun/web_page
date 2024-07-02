package com.java2403.dao;

import com.java2403.entity.Student;
import com.java2403.util.JDBCUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    /**
     * 查询全部学生信息
     * @return 返回学生集合
     */
    public List<Student> queryAllStudent(){

        List<Student> slist  = new ArrayList<>();

        ResultSet rs  =  JDBCUtils.doQuery("select sno ,sname,password,sex,age from t_student");
        try{
            while (rs.next()){
                Student stu   = new Student();
                stu.setSno(rs.getInt("sno"));
                stu.setSname(rs.getString("sname"));
                stu.setPassword(rs.getString("password"));
                stu.setSex(rs.getString("sex"));
                stu.setAge(rs.getInt("age"));
                slist.add(stu);

            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.doClose(rs);
        }
        return  slist;
    }

    /**
     * 添加学生信息
     * @param stu 学生对象
     * @return 是否成功
     */
    public boolean addStudent(Student stu){
        String sql  = "insert into t_student(sname,password,sex,age)values(?,?,?,?)";
        int count  =   JDBCUtils.doUpdate(sql,stu.getSname(),stu.getPassword(),stu.getSex(),stu.getAge());
        return  count>0;
    }

    // 1 登录方法 login(sno,sname) .... 2 模糊查询 根据姓名查询学生信息  3 修改学生信息  4 删除学生



    public boolean login(int sno,String password)  {
        String sql = "select sno from t_student where sno =? and password = ? ";
        ResultSet rs  =   JDBCUtils.doQuery(sql,sno,password);
        boolean flag  =false;
        try {
            if(rs.next()){
                flag = true; // 有下一个，就说明 有内容，说明根据条件 有查到数据 ，账号密码是正确的
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static void main(String[] args) {

        System.out.println(   new StudentDao().login(100,"123"));


    }

    // 选做： 分页查询（难度）  分组查询等等
}
