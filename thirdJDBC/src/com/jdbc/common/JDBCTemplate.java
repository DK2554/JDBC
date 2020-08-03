package com.jdbc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	// connection 객체를 만들어주는 기능
	// statment,preparedstatement,resultset객체 반환 메소드
	// rollback,commit
	// 공용으로 사용하는 기능을 구현->static메소드로 구현을 함.

	// Connection생성해서 반환해주는 메소드 작성
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
			System.out.println("드라이버 접속");
			// 트렌젹션에 대한 옵션 설정
			con.setAutoCommit(false);// 개발자가 트렌젝션 컨트롤하기 위해서..설정

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	// 객체를 반환 하는 공통 메소드 작성
	// 메소드 오버로딩을 하여 편리하게 객체를 닫을수 있게 작성
	// connection
	public static void close(Connection con) {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// preparedStatement statemtent상속
	public static void close(Statement stmt) {
		try {
			if (stmt != null && !stmt.isClosed()) {
				stmt.close();// statement,preparedstatement반환가능
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void commit(Connection con) {
		try {
			if (con != null && !con.isClosed()) {
				con.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection con) {
		try {
			if (con != null & !con.isClosed()) {
				con.rollback();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
