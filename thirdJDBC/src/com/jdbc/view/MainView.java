package com.jdbc.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jdbc.controller.MemberController;
import com.jdbc.model.vo.Member;

public class MainView {
	private MemberController controller = new MemberController();

	public void mainMenu() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("==== 회원 관리 v2 =====");
			System.out.println("1.전체 회원 조회하기");
			System.out.println("2.이름으로 회원 조회하기");
			System.out.println("3.아이디로 회원조회 하기");
			System.out.println("4.회원등록하기");
			System.out.println("5.회원수정하기");
			System.out.println("6.회원삭제하기");
			System.out.println("9.프로그램 종료하기");
			System.out.print("선택 : ");
			switch (sc.nextInt()) {
			case 1:
				controller.searchMemberAll();
				break;
			case 2:
				controller.searchMemberName();
				break;
			case 3:
				controller.searchMemberId();
				break;
			case 4:
				controller.insertMember();
				break;
			case 5:
				controller.updateMeber();
				break;
			case 6 :
				controller.deleteMember();
				break;
				
			}
		}

	}

	public void printMember(List<Member> list) {
		System.out.println("========전체조회 결과======");
		if (list.isEmpty()) {
			System.out.println("조회한 결과가 없습니다");
		} else {
			for (Member m : list) {
				System.out.println(m);
			}

		}
	}

	public void print(ArrayList<Member> member, String title) {
		System.out.println("==" + title + "으로 조회결과==");
		for (Member mm : member) {
			System.out.println(mm);
		}

	}

	public String inputId(String title) {
		Scanner sc = new Scanner(System.in);
		System.out.println("===조회할 " + title + "입력 ==");
		System.out.print(title + " : ");
		String text = sc.nextLine();
		return text;
	}
	public Member deleteMember() {
		Scanner sc=new Scanner(System.in);
		Member m=new Member();
		System.out.println("==회원 삭제==");
		System.out.print("삭제할 회원의 아이디  : ");
		m.setMemberId(sc.nextLine());
		return m;
				
	}
	public Member updateMember() {
		Scanner sc =new Scanner(System.in);
		Member m=new Member();
		System.out.println("==회원 수정==");
		System.out.print("수정할 아이디 입력: ");
		m.setMemberId(sc.nextLine());
		System.out.print("변경할 이름: ");
		m.setMemberName(sc.nextLine());
		System.out.print("변경할 전화번호 : ");
		m.setPhone(sc.nextLine());
		System.out.print("변경할 이메일 : ");
		m.setEmail(sc.nextLine());
		
		return m;
	}

	public Member insertMember() {
		System.out.println("===회원등록===");
		Scanner sc = new Scanner(System.in);
		Member m = new Member();
		System.out.print("아이디 : ");
		m.setMemberId(sc.nextLine());
		System.out.print("패스워드 : ");
		m.setMemberPwd(sc.nextLine());
		System.out.print("이름 : ");
		m.setMemberName(sc.nextLine());
		System.out.print("성별(M/F) : ");
		m.setGender(sc.nextLine());
		System.out.print("나이 :");
		m.setAge(sc.nextInt());
		sc.nextLine();
		System.out.print("이메일 :");
		m.setEmail(sc.nextLine());
		System.out.print("주소 :");
		m.setAddress(sc.nextLine());
		System.out.print("취미 :");
		m.setHobby(sc.nextLine());

		return m;
	}

	public void printMsg(String msg) {
		System.out.println("===시스템====");
		System.out.println(msg);

	}

}
