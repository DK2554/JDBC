package com.jdbc.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jdbc.model.vo.Member;

public class MemberDao {
	// 설정한 DB에 접속해서 데이터를 조회하여 가져오고
	// 삽입하고 수정하고 삭제하는 기능!
	// Member테이블에 대한것/...

	public ArrayList<Member> searchMemberAll() {
		// 1. DB 접속
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Member> memberlist = null;
		Member member = null;
		String sql = "SELECT * FROM MEMBER";
		try {// git
				// 드라이브 등록하기
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 접속 성공");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			memberlist = new ArrayList<Member>();
			while (rs.next()) {
				member = new Member(rs.getString("member_id"), rs.getString("member_pwd"), rs.getString("member_name"),
						rs.getString("gender"), rs.getInt("age"), rs.getString("email"), rs.getString("phone"),
						rs.getString("address"), rs.getString("hobby"), rs.getDate("enroll_date"));
				memberlist.add(member);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberlist;

	}

	public Member searchMemberId(String id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Member member = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 접속 성공");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
			stmt = conn.createStatement();
			String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID='" + id + "'";
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPwd(rs.getString("member_pwd"));
				member.setMemberName(rs.getString("member_name"));
				member.setGender(rs.getString("gender"));
				member.setAge(rs.getInt("age"));
				member.setEmail(rs.getString("email"));
				member.setPhone(rs.getString("phone"));
				member.setAddress(rs.getString("address"));
				member.setHobby(rs.getString("hobby"));
				member.setEnrollDate(rs.getDate("enroll_date"));

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return member;

	}

	public ArrayList<Member> searchMemberName(String userName) {
		// 선언
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Member member = null;
		ArrayList<Member> memberlist = new ArrayList<Member>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 접속 성공");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
			stmt = con.createStatement();
			String sql = "SELECT * FROM MEMBER WHERE MEMBER_NAME like '%" + userName + "%'";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPwd(rs.getString("member_pwd"));
				member.setMemberName(rs.getString("member_name"));
				member.setGender(rs.getString("gender"));
				member.setAge(rs.getInt("age"));
				member.setEmail(rs.getString("email"));
				member.setPhone(rs.getString("phone"));
				member.setAddress(rs.getString("address"));
				member.setHobby(rs.getString("hobby"));
				member.setEnrollDate(rs.getDate("enroll_date"));
				memberlist.add(member);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberlist;
	}

	// insert문-> 삽입된 수 반환-> int
	public int insertMember(Member m) {
		Connection con = null;
		Statement stmt = null;
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 접속 성공");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
			stmt = con.createStatement();
			String insert = "INSERT INTO MEMBER VALUES('" + m.getMemberId() + "','" + m.getMemberPwd() + "'" + ",'"
					+ m.getMemberName() + "'" + ",'" + m.getGender() + "'" + ",'" + m.getAge() + "'" + ",'"
					+ m.getEmail() + "'" + ",'" + m.getPhone() + "'" + ",'" + m.getAddress() + "'" + ",'" + m.getHobby()
					+ "'" + ",SYSDATE)";
			result = stmt.executeUpdate(insert);
			// 정상적으로 입력되면 commit,아니면rollback;
			if (result > 0) {
				con.commit();
			} else {
				con.rollback();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public int updateMember(Member m) {
		// DB연결선언부
		Connection con = null;
		Statement stmt = null;

		int result = 0;
	
		// 드라이브 등록
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이브접속 성공");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
			stmt = con.createStatement();
			System.out.println("여기까지는 되나?");
			//진심빡치는 쿼리문 숫자입력할때 ''을 입력해서 오류나는거였음 캬아아아아ㅏ아아아아아앙
			
			String update ="UPDATE MEMBER SET MEMBER_NAME='"+m.getMemberName()+"'" 
					+","+"AGE="+m.getAge()+""
					+","+"PHONE='"+m.getPhone()+"'"
					+","+"EMAIL='"+m.getEmail()+"'"
					+"WHERE MEMBER_ID='"+m.getMemberId()+"'";
			result=stmt.executeUpdate(update);
			
			if(result>0) {
				con.commit();
			}else {
				con.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;

	}
}
