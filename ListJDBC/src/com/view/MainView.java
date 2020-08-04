package com.view;

import java.util.Scanner;

import com.controller.MemberController;

public class MainView {
	private MemberController controller = new MemberController();

	public void mainMenu() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("메인메뉴=====");
			System.out.println("1.회원 관리");
			System.out.println("2.게시판 관리");
			System.out.print("3.프로그램 종료");
			switch (sc.nextInt()) {
			case 1:
				member();
				break;

			}
		}

	}

	public void member() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			
			System.out.println("1.전체회원 조회");
			System.out.println("2.회원 아이디로 조회");
			System.out.println("3.회원 이름으로 조회");
			System.out.println("4.회원가입");
			System.out.println("5.회원정보수정(주소,전화번호,이메일)");
			System.out.println("6.회원탈퇴");
			System.out.println("7.메인메뉴로");
			switch(sc.nextInt()) {
			case 1:controller.searchMemberAll();break;
			}
		}
		
	}

}
