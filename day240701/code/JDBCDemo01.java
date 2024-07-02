package code;

import java.sql.*;

public class JDBCDemo01 {


    public static void main(String[] args)  {

        Connection  conn  = null;
        PreparedStatement psm = null;
        ResultSet rs  = null;


        try {

          // 1 加载驱动
          //
//          Class.forName("com.mysql.cj.jdbc.Driver");

          //  2 建立链接： 通过驱动管理(管家)， 获得一个 连接对象（连接者）
          // 三个参数：地址（连接地址 带上数据库名 ） 用户名  密码
            conn  =  DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","root");


          // 获得一个 执行 语句 对象  参数为 sql语句，切记 查询中 尽量不要用 *  ，不方便维护
           psm  = conn.prepareStatement("select sno,sname,password,sex,age from t_student");
          //  执行语句(或者先 加入 参数)
           rs  =  psm.executeQuery();// 查询，获得结果集
          //psm.executeUpdate()// 更新，获得执行行数
          // 处理结果(集合)、
          while(rs.next()){

              System.out.println(
                      rs.getInt("sno")+","+
                              rs.getString("sname")+","+
                              rs.getString("password")+","+
                              rs.getString("sex")+","+
                              rs.getInt("age")
              );

          }

      }catch (Exception e){
            e.printStackTrace();
      }finally {
          // 关闭资源
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(rs!=null){
                try {
                    psm.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if(rs!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }


      }







    }



}
