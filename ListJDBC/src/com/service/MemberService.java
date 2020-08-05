package com.service;

import static com.common.ConnectionPool.close;
import static com.common.ConnectionPool.commit;
import static com.common.ConnectionPool.getConnection;
import static com.common.ConnectionPool.rollback;

import java.sql.Connection;
import java.util.List;

import com.model.dao.BoardDao;
import com.model.dao.MemberDao;
import com.model.vo.Board;
import com.model.vo.Emp;
import com.sun.javafx.sg.prism.NGImageView;

public class MemberService {
		private MemberDao dao=new MemberDao();
		private BoardDao bdao=new BoardDao();
	public List<Emp> searchMemberAll() {
		Connection con=getConnection();
		List<Emp>list=dao.searchMemberAll(con);
		close(con);
		return list;
	}
	public int insertMember(Emp e) {
		Connection con=getConnection();
		int result=dao.insertMember(con,e);
		if(result>0) commit(con);
		else rollback(con);
		close(con);
		return result;
		
	}
	public List<Emp> searchMemberId(String id) {
		Connection con=getConnection();
		List<Emp>list=dao.searchMemberId(con,id);
		close(con);
		return list;
	}
	public List<Emp> searchMemberName(String userName) {
		Connection con=getConnection();
		List<Emp>list=dao.searchMemberName(con,userName);
		close(con);
		return list;
	}
	public int deleteMember(Emp e) {
		Connection con=getConnection();
		int result=dao.deleteMember(con,e);
		if(result>0)commit(con);
		else rollback(con);
		close(con);
		return result;
	}
	public int updateMember(Emp e) {
		Connection con=getConnection();
		int result=dao.updateMember(con,e);
		if(result>0)commit(con);
		else rollback(con);
		close(con);
		return result;
		
	}
	public List<Board> searchboardAll() {
		Connection con=getConnection();
		List<Board> blist=bdao.searchAll(con);
		close(con);
		return blist;
		
		
	}
	public int insertboard(Board bo) {
		Connection con=getConnection();
		int result=bdao.insertboard(con,bo);
		if(result>0)commit(con);
		else rollback(con);
		close(con);
		return result;
	
		
	}
	public int deleteboard(Board bo) {
		Connection con=getConnection();
		int result=bdao.deleteboard(con,bo);
		if(result>0)commit(con);
		else rollback(con);
		close(con);
		return result;
		
		
	}
	public void searchwriter(String writer) {
		Connection con=getConnection();
		bdao.searchwriter(con,writer);
		
	}

}
