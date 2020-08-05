package com.model.dao;

import java.io.FileReader;
import static com.common.ConnectionPool.close;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.model.vo.Emp;

public class MemberDao {
	private Properties prop = new Properties();

	public MemberDao() {
		// 기본생성자를 통해서 Properties설정
		try {
			prop.load(new FileReader("resource/member_query.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public List<Emp> searchMemberAll(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Emp> list = new ArrayList<Emp>();
		String sql = prop.getProperty("memberAll");
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Emp e = new Emp();
				e.setMemberNo(rs.getInt("member_no"));
				e.setMemberId(rs.getString("member_id"));
				e.setMemberPwd(rs.getString("member_pwd"));
				e.setMemberName(rs.getString("member_name"));
				e.setEmail(rs.getString("email"));
				e.setAddress(rs.getString("address"));
				e.setPhone(rs.getString("phone"));
				e.setEnrollDate(rs.getDate("enroll_date"));
				list.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;

	}

	public int insertMember(Connection con, Emp e) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("insertMember");
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,e.getMemberId());
			pstmt.setString(2, e.getMemberPwd());
			pstmt.setString(3, e.getMemberName());
			pstmt.setString(4, e.getEmail());
			pstmt.setString(5, e.getAddress());
			pstmt.setString(6,e.getPhone());
			result=pstmt.executeUpdate();
		}catch(SQLException o) {
			o.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public List<Emp> searchMemberId(Connection con, String id) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Emp m=null;
		List<Emp> list=new ArrayList<Emp>();
		String sql=prop.getProperty("memberid");
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				m=new Emp();	
				m.setMemberNo(rs.getInt("member_no"));
				m.setMemberId(rs.getString("member_id"));
				m.setMemberPwd(rs.getString("member_pwd"));
				m.setMemberName(rs.getString("member_name"));
				m.setEmail(rs.getString("email"));
				m.setAddress(rs.getString("address"));
				m.setPhone(rs.getString("phone"));
				m.setEnrollDate(rs.getDate("enroll_date"));
				list.add(m);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public List<Emp> searchMemberName(Connection con, String userName) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("membername");
		List<Emp>list=new ArrayList<Emp>();
		Emp e=null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userName);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				e=new Emp();
				e.setMemberNo(rs.getInt("member_no"));
				e.setMemberId(rs.getString("member_id"));
				e.setMemberPwd(rs.getString("member_pwd"));
				e.setMemberName(rs.getString("member_name"));
				e.setEmail(rs.getString("email"));
				e.setAddress(rs.getString("address"));
				e.setPhone(rs.getString("phone"));
				e.setEnrollDate(rs.getDate("enroll_date"));
				list.add(e);
				
			}
		}catch(SQLException o) {
			o.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public int deleteMember(Connection con, Emp e) {
		PreparedStatement pstmt=null;
		int result =0;
		String sql=prop.getProperty("memberdelete");
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, e.getMemberId());
			result=pstmt.executeUpdate();	
		}catch(SQLException o) {
			o.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}

	public int updateMember(Connection con,Emp e) {
		PreparedStatement pstms=null;
		int result=0;
		String sql=prop.getProperty("updatemember");
		try {
			pstms=con.prepareStatement(sql);
			pstms.setString(1,e.getAddress());
			pstms.setString(2,e.getPhone());
			pstms.setString(3, e.getEmail());
			pstms.setString(4,e.getMemberId());
			result=pstms.executeUpdate();
		}catch(SQLException o) {
			o.printStackTrace();
		}finally {
			close(pstms);
		}
		return result;
		
	}

	
}
