package com.jdbc.model.servie;

import static com.jdbc.common.JDBCTemplate.close;
import static com.jdbc.common.JDBCTemplate.getConnection;
import static com.jdbc.common.JDBCTemplate.commit;
import static com.jdbc.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.model.dao.MemberDao;
import com.jdbc.model.vo.Member;

public class MemberService {

	private MemberDao dao = new MemberDao();

	public List<Member> searchMemberAll() {
		// 1.Connection 객체를 생성->JDBCTemplate라는 공용객체에서 생성함
		// 2. 생성한 connection객체를 dao 전달
		// 3.connection을 이클래스에서 관리를 하기 때문에 트렌젝션관리도 여기서함
		// 4.dao에서 전달받은 결과를 controller로 return
		Connection con = getConnection();
		// dao에 데이터를 조작하는 기능을 호출할때 conntion객체를 매개변수로 보내줌
		List<Member> list = dao.searchMemberAll(con);
		close(con);
		return list;
	}

	public List<Member> searchMemberName(String name) {
		Connection con = getConnection();
		List<Member> m = dao.searchMemberName(con, name);
		close(con);
		return m;

	}

	public int insertMember(Member m) {
		Connection con = getConnection();
		int result = dao.insertMember(con, m);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public List<Member> searchMEmberId(String userId) {
		Connection con=getConnection();
		List<Member>mm=dao.searchMemberId(con,userId);
		close(con);
		return mm;
	}

	public int updateMember(Member m) {
		Connection con=getConnection();
		int result=dao.updateMeber(con,m);
		if(result>0) commit(con);
		else rollback(con);
		close(con);
		return result;
		
	}

	public int deleteMember(Member m) {
		Connection con=getConnection();
		int result=dao.deleteMember(con,m);
		if(result>0) commit(con);
		else rollback(con);
		close(con);
		return result;
	}

}
