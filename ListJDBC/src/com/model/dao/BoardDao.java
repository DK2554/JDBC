package com.model.dao;

import static com.common.ConnectionPool.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.model.vo.Board;



public class BoardDao {
	private Properties prop = new Properties();

	public BoardDao() {
		// 기본생성자를 통해서 Properties설정
		try {
			prop.load(new FileReader("resource/board_query.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public List<Board> searchAll(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Board> list = new ArrayList<Board>();
		String sql = prop.getProperty("boardAll");
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Board b = new Board();
				b.setBoard_no(rs.getInt("board_no"));
				b.setDiv(rs.getString("div"));
				b.setTitle(rs.getString("title"));
				b.setComent(rs.getString("coment"));
				b.setWriter(rs.getString("writer"));
				b.setWriter_date(rs.getDate("write_date"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;

	}

	public int insertboard(Connection con, Board bo) {
		PreparedStatement pstmt=null;
		int result =0;
		String sql=prop.getProperty("insertboard");
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, bo.getDiv());
			pstmt.setString(2, bo.getTitle());
			pstmt.setString(3, bo.getComent());
			pstmt.setString(4, bo.getWriter());
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}

	public int deleteboard(Connection con,Board bo) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("deleteboard");
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, bo.getWriter());
			result=pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}

	public List<Board> searchwriter(Connection con, String writer) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Board b=null;
		List<Board>list =new ArrayList<Board>();
		String sql=prop.getProperty("searchwriter");
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,writer);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				b=new Board();
				b.setBoard_no(rs.getInt("board_no"));
				b.setDiv(rs.getString("div"));
				b.setTitle(rs.getString("title"));
				b.setComent(rs.getString("coment"));
				b.setWriter(rs.getString("writer"));
				b.setWriter_date(rs.getDate("write_date"));
				list.add(b);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return list;
		
	}

	public List<Board> searchboardtitle(Connection con, String title) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Board b=null;
		List<Board>list=new ArrayList<Board>();
		String sql=prop.getProperty("searchtitle");
				try {
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,title);
					rs=pstmt.executeQuery();
					if(rs.next()) {
						b=new Board();
						b.setBoard_no(rs.getInt("board_no"));
						b.setDiv(rs.getString("div"));
						b.setTitle(rs.getString("title"));
						b.setComent(rs.getString("coment"));
						b.setWriter(rs.getString("writer"));
						b.setWriter_date(rs.getDate("write_date"));
						list.add(b);
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					close(pstmt);
					close(rs);
				}
				return list;
	
		
	}

	public int updateboard(Connection con, Board upno) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("updateboard");
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, upno.getTitle());
			pstmt.setString(2, upno.getComent());
			pstmt.setInt(3, upno.getBoard_no());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

}
