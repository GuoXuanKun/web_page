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


    /**
     * 登录
     * @param sno  学号
     * @param password 密码
     * @return  登录成功（true）或失败（false）
     */
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

    /**
     * 根据学号删除学生信息
     * @param sno 序列号
     * @return 是否删除成功
     */
    public boolean deleteBySno(int sno){
        String sql = "delete from t_student where sno = ?";
        int flag = JDBCUtils.doUpdate(sql, sno);
        return flag > 0;
    }

    /**
     * 修改学生信息
     * @param stu
     * @return
     */
    public boolean modify(Student stu){
        String sql  ="update t_student set sname = ?,sex = ?,password = ? ,age = ? where sno = ? ";
        int t = JDBCUtils.doUpdate(sql,stu.getSname(),stu.getSex(),stu.getPassword(),stu.getAge(),stu.getSno());
        return t>0;
    }

    /**
     * 模糊查询 根据学生姓名
     * @param sname 学生姓名
     * @return 查询到的所有学生
     */
    public List<Student> queryStuByLike(String sname){
        List<Student> students = new ArrayList<>();
        String sql = "select sno ,sname, password, sex, age from t_student where sname like concat('%', ? ,'%')";
        ResultSet rs  =  JDBCUtils.doQuery(sql, sname);
        try{
            while (rs.next()){
                Student stu   = new Student();
                stu.setSno(rs.getInt("sno"));
                stu.setSname(rs.getString("sname"));
                stu.setPassword(rs.getString("password"));
                stu.setSex(rs.getString("sex"));
                stu.setAge(rs.getInt("age"));
                students.add(stu);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.doClose(rs);
        }
        return students;
    }



    /**
     * 根据学号 查询学生信息
     * @param sno
     * @return
     */
    public Student queryMyInfo(int sno) {
        ResultSet rs = JDBCUtils.doQuery("select sno,sname,password,sex,age from t_student where sno = ?",sno);
        Student my = null;
        while (true) {
            try {
                while(rs.next()){
                    my = new Student();
                    my.setSno(sno);
                    my.setSname(rs.getString("sname"));
                    my.setPassword(rs.getString("password"));
                    my.setSex(rs.getString("sex"));
                    my.setAge(rs.getInt("age"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally{
                JDBCUtils.doClose(rs);
            }
            return my;
        }
    }

    /**
     * 分页的方式查询
     * @param pageIndex 第几页
     * @param pageSize  一页几条
     * @return
     */
    public List<Student> queryAllStudentByPage(int pageIndex,int pageSize){

        List<Student> slist  = new ArrayList<>();
        String sql  ="select sno ,sname,password,sex,age from t_student limit ?,?";
        //                                    (页数-1)*一页几条
        ResultSet rs  =  JDBCUtils.doQuery(sql,(pageIndex-1)*pageSize,pageSize);
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





    public static void main(String[] args) {

        StudentDao studentDao = new StudentDao();
        List<Student> list = studentDao.queryAllStudentByPage(1,3);
        for (Student stu: list ) {
            System.out.println(stu);
        }
    }

}
