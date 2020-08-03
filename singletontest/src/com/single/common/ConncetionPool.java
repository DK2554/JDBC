package com.single.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConncetionPool {
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "scott");
			System.out.println("드라이버 접속");
			con.setAutoCommit(false);//트렌젝션을 직접 수행해주기 위함
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	//오버로딩
	
	public static void close(Connection con) {
		try {
			if(con!=null&&!con.isClosed()) {
				con.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			if(stmt!=null && !stmt.isClosed()) {
				stmt.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			if(rs!=null&& !rs.isClosed()) {
				rs.close();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void commit(Connection con) {
		try {
			if(con!=null&& !con.isClosed())
			{
				con.commit();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection con) {
		try {
			if(con!=null&&!con.isClosed()) {
				con.rollback();
			}
		}catch(SQLException e ) {
			e.printStackTrace();
		}
	}
	

}
