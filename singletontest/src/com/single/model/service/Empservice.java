package com.single.model.service;

import static com.single.common.ConncetionPool.close;
import static com.single.common.ConncetionPool.getConnection;

import java.sql.Connection;
import java.util.List;

import com.single.model.dao.EmpDao;
import com.single.model.vo.Emp;


public class Empservice {
	private EmpDao dao=new EmpDao(); 

	public List<Emp> searchEmpAll() {
		Connection con=getConnection();
		List<Emp> e=dao.searchMemberAll(con);
		close(con);
		return e;
		
	}

	public int insertEmp() {
		Connection con=getConnection();
		//dao.insertEmp(con);
		int result=0;
		close(con);
		return result;
		
	}

}
