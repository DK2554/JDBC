package com.service;

import java.sql.Connection;
import static com.common.ConnectionPool.getConnection;
import static com.common.ConnectionPool.close;

import com.model.dao.MemberDao;

public class MemberService {
		private MemberDao dao=new MemberDao();
	public void searchMemberAll() {
		Connection con=getConnection();
		
		dao.searchMemberAll(con);
		
		
	}

}
