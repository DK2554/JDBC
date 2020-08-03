package com.single.controller;

import java.util.ArrayList;
import java.util.List;

import com.single.model.service.Empservice;
import com.single.model.vo.Emp;
import com.single.view.MainView;

public class EmpController {
	private Empservice service = new Empservice();
	public void mainMenu() {
		new MainView().mainMenu();
	}
	public void searchEmpAll() {
		List<Emp> e=service.searchEmpAll();
		new MainView().printMember(e);
		
	}
	public int insertEmp() {
		new MainView().insertEmp();
		int result =service.insertEmp();
		return result;
	}

}
