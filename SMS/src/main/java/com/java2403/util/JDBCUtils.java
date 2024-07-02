package com.java2403.util;

import com.java2403.entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JDBCUtils {

	// 1驱动地址（不同数据库版本可能有不同）
	private static final String driverPath = "com.mysql.cj.jdbc.Driver";
	// 2 连接数据库地址（注意根据自己的情况，修改 数据库名 和账号 密码） characterEncoding=utf8 防止中文乱码
	private static final String path = "jdbc:mysql://localhost:3306/sms?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
	// 3 数据库用户名
	private static final String username = "root";
	// 4 数据库密码
	private static final String password = "root";

	// 4 个方法（获得数据库连接对象getConn 关闭资源的方法 doClose 查询方法doQuery 增删改 方法doUpdate ）

	/**
	 * 获得数据库连接语句对象
	 * 
	 * @return 数据库连接语句对象
	 */

	public static Connection getConn() {
		Connection conn = null;
		try {
			// 加载驱动
			Class.forName(driverPath);
			// 获得数据库连接对象
			conn = DriverManager.getConnection(path, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}

	/**
	 * 执行增删改操作
	 * 
	 * @param sql  sql语句
	 * @param objs 对应的参数（一个萝卜一个坑）
	 * @return 返回执行影响行数
	 */

	public static int doUpdate(String sql, Object... objs) {
		int count = 0;
		PreparedStatement ps = null;
		// 1 获得连接对象
		Connection conn = getConn();
		try {
			// 2 获得执行语句对象
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				ps.setObject(i + 1, objs[i]);
			}
			// 执行语句，获得执行行数
			count = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return count;
	}

	/**
	 * 关闭数据库对象
	 * 
	 * @param rs
	 */
	public static void doClose(ResultSet rs) {

		Connection conn = null;
		Statement ps = null;

		if (rs != null) {
			// rs关闭前先把 ps 对象 拿到手

			try {
				// 通过 结果集对象的get方法，获得 执行语句对象
				ps = rs.getStatement();
				// 通过执行语句对象 的get方法，获得 连接语句对象
				conn = ps.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			// 关闭结果集对象
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			return;
		}
		// 关闭执行语句对象
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 关闭数据库连接对象
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * 运行查询，返回结果集
	 * 
	 * @param sql  sql语句
	 * @param objs 对应的参数（一个萝卜一个坑）
	 * @return 返回结果集
	 */
	public static ResultSet doQuery(String sql, Object... objs) {
		// 结果集
		ResultSet rs = null;
		// 连接语句对象
		Connection conn = getConn();
		// 当连接失败，则返回null
		if (conn == null) {
			return null;
		}
		try {
			// 执行语句
			PreparedStatement ps = conn.prepareStatement(sql);
			// 根据插进来的参数，进行赋值（一个萝卜一个坑）
			for (int i = 0; i < objs.length; i++) {
				ps.setObject(i + 1, objs[i]); // 注意：为什么用i+1
			}
			// 执行语句，得到结果集
			rs = ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回结果集
		return rs;
	}

	public static void main(String[] args) throws SQLException {


		// 1 查询全部 2 根据学号查询 3 根据姓名模糊查询  4 更新数据（修改个人信息 根据sno）
		// 如果写方法（dao中方法），怎么写 boolean addStudent(Student stu){ ... }




//		int count  = JDBCUtils.doUpdate("delete from t_student where sno =?",108);
//		System.out.println(count);
		String sql  ="select sno,sname,password,sex,age from t_student where sno =? and sname=? and password =?";
		ResultSet rs   =  JDBCUtils.doQuery(sql,100,"zhw","123");
		List<Student> slist   = new ArrayList<>();
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

		JDBCUtils.doClose(rs);

	}
	
}
