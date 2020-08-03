package com.single.view;

import java.util.List;
import java.util.Scanner;

import com.single.controller.EmpController;
import com.single.model.vo.Emp;

public class MainView {
	private EmpController controller = new EmpController();

	public void mainMenu() {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("1.전체회원조회하기 ");
			System.out.println("2.이름으로조회하기");
			System.out.println("3.아이디로 조회하기");
			System.out.println("4.회원등록하기");
			System.out.println("5.회원수정하기");
			System.out.println("6.회원삭제하기");
			System.out.println("9.프로그램 종료");
			System.out.print("입력 : ");
			switch (sc.nextInt()) {
			case 1:
				controller.searchEmpAll();break;
			case 4:
				controller.insertEmp();break;

			}
		}

	}

	public void printMember(List<Emp> e) {
		System.out.println("=====전체 조회 결과=====");
		if (e.isEmpty()) {
			System.err.println("조회한 결과가 없습니다");
		} else {
			for (Emp em : e) {
				System.out.println(em);
			}
		}

	}

	public Emp insertEmp() {
		System.out.println("=== 회원 등록 =====");
		Scanner sc=new Scanner(System.in);
		Emp m=new Emp();
		System.out.print("사원번호 : ");
		m.setEmpno(sc.nextInt());
		buffer();
		System.out.print("사원명 : ");
		m.setEnmae(sc.nextLine());
		System.out.print("직책명 : ");
		m.setJob(sc.nextLine());
		System.out.print("사수번호 : ");
		m.setMgr(sc.nextInt());
		buffer();
		System.out.print("월급 : ");
		m.setMgr(sc.nextInt());
		buffer();
		System.out.print("사수번호 : ");
		m.setMgr(sc.nextInt());
		buffer();
		
		
		
		return m;
		
	}
	public void buffer() {
		Scanner sc=new Scanner(System.in);
		sc.nextLine();
	}
	

}
