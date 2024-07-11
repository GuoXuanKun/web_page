package com.java2403.util;

import java.sql.*;

public class JDBC非法注入测试 {

	public static void 普通执行语句对象的使用() throws SQLException {

		//String sname  ="zhw";
		String sname  ="zhw' or '1'='1";
		String password="666666666";

		String sql ="select sno,password from t_student where sname ='"+ sname + "' and password= '"+ password +"' ";
		// 拼接后，是一个完整的sql语句
			Connection  conn  =JDBCUtils.getConn();
			// 创建的不是预编译执行语句对象 普通的执行语句对象
			Statement statement  =  conn.createStatement();

			ResultSet rs   = 	statement.executeQuery(sql);
			// 执行后，就会出现 非法注入的情况（sql语句 直接传递 ，没办法 进一步 校验  无脑执行）
			while (rs.next()){
				System.out.println(rs.getString("sno")+"," + rs.getString("password"));
			}

	}

	public static void 预编译执行语句对象的使用1() throws SQLException {

		//String sname  ="zhw";
		String sname  ="zhw' or '1'='1";
		String password="666666666";

		String sql ="select sno,password from t_student where sname ='"+ sname + "' and password= '"+ password +"' ";
		// 拼接后，是一个完整的sql语句
		Connection  conn  =JDBCUtils.getConn();
		// 创建的是预编译执行语句对象 但是 直接 传递 拼接好的  sql语句
		PreparedStatement statement  =  conn.prepareStatement(sql);

		ResultSet rs   = 	statement.executeQuery();
		// 既然是 拼接好的，它也没办法 直到 你的故意的还是  无意的
		// 执行后，就会出现 非法注入的情况（sql语句 直接传递 ，没办法 进一步 校验  无脑执行）
		while (rs.next()){
			System.out.println(rs.getString("sno")+"," + rs.getString("password"));
		}

	}


	public static void 预编译执行语句对象的使用2() throws SQLException {

		//String sname  ="zhw";
		String sname  ="zhw' or '1'='1";
		String password="666666666";

		String sql ="select * from t_student where sname =? and password=?";
		// 拼接后，是一个完整的sql语句
		Connection  conn  =JDBCUtils.getConn();
		// 创建的是预编译执行语句对象 但是 直接 传递 不是拼接好的sql语句，而是 使用  问号  占位
		PreparedStatement psm  =  conn.prepareStatement(sql);
		//  参数使用 setXxxx方式，传递进来 ，预编译执行语句对象，由权利 怀疑 是否有非法注入（如果有，就采取 应对措施）

		psm.setString(1,sname);
		psm.setString(2,password);

		ResultSet rs   = 	psm.executeQuery();

		while (rs.next()){
			System.out.println(rs.getString("sno")+"," + rs.getString("password"));
		}

	}


	public static void main(String[] args) throws SQLException {


		预编译执行语句对象的使用2();


	}









}
