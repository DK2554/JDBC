package com.common;


import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionPool {
	// connection객체 만들기
	// statment,preparedstatement,resultset객체반환메소드
	public static Connection getConnection() {
		Connection con = null;
		try {
			// 오라클 드라이버에 연결 설정하기
			// Properties객체를이용해서 드라이버 연결
			Properties driver = new Properties();
			driver.load(new FileReader("resource/DriverManager.properties"));
			Class.forName(driver.getProperty("driver"));
			con = DriverManager.getConnection(driver.getProperty("url"),driver.getProperty("user"),driver.getProperty("pw"));
			System.out.println("드라이버 접속 성공");
			con.setAutoCommit(false);// 개발자 트렌젹션을 컨트롤

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	//close 메소드 오버로딩하기
	//con닫아주기
	public static void close(Connection con) {
		try {
			if(con!=null && !con.isClosed()) {
				con.close();
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			if(stmt!=null&& !stmt.isClosed()) {
				stmt.close();
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			if(rs!=null& !rs.isClosed()) {
				rs.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void commit(Connection con) {
		try {
			if(con!=null&&!con.isClosed()) {
				con.commit();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection con) {
		try {
			if(con!=null&&!con.isClosed())
			{
				con.rollback();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
