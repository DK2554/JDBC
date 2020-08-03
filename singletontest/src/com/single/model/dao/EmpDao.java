package com.single.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static com.single.common.ConncetionPool.close;

import com.single.model.vo.Emp;

public class EmpDao {

	public ArrayList<Emp> searchMemberAll(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Emp> list = new ArrayList<Emp>();
		String sql = "SELECT * FROM EMP ";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Emp e = new Emp();
				// 정보를 담을 객체 vo생성
				e.setEmpno(rs.getInt("empno"));
				e.setEnmae(rs.getString("ename"));
				e.setJob(rs.getString("job"));
				e.setMgr(rs.getInt("mgr"));
				e.setHiredate(rs.getDate("hiredate"));
				e.setSal(rs.getInt("sal"));
				e.setComm(rs.getInt("comm"));
				e.setDeptno(rs.getInt("deptno"));
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

	public int insertEmp() {
		PreparedStatement pstmt=null;
		int result=0;
		String sql="INSERT INTO EMP VALUES(?,?,?,?,?,?,?,?)";
		
		
		return result;
		
	}
}
