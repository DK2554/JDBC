package com.jdbc.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.jdbc.controller.MemberController;
import com.jdbc.model.vo.Member;

public class MainView {
	//각종 화면을 제공하는 기능을 가지고 있는 클래스
	private MemberController controller=new MemberController();
	Scanner sc=new Scanner(System.in);
	public void mainMenu() {
		
		while(true) {
			System.out.println("=====회원관리 프로그램 v.1=====");
			System.out.println("1. 전체회원조회하기");
			System.out.println("2. 이름으로 조회하기");
			System.out.println("3. 아이디로 조회하기");
			System.out.println("4. 회원등록하기");
			System.out.println("5. 회원수정하기");
			System.out.println("6. 회원삭제하기");
			System.out.println("0. 프로그램종료하기!");
			System.out.print("입력 : ");
			int cho=sc.nextInt();
			sc.nextLine();
			switch(cho) {
			case 1:controller.searchMemberAll();break;
			case 2:controller.searchMemberName();break;
			case 3:controller.searchMemberId();break;
			case 4:controller.insertMember();break;
			case 5:controller.updateMember();break;
			case 6:controller.deleteMember();break;
			case 0:System.out.println("프로그램을 종료합니다");return;
			}
			
		}
	}
	public void printMember(ArrayList<Member> members) {
		System.out.println("===== 등록된 회원 =====");
		if(members.size()>0) {
			for(Member m: members) {
				System.out.println(m);
			}	
		}else {
			System.out.println("결과가 없습니다");
		}
	
	}
	public void printMemberId(Member member) {
		System.out.println("===조회된  회원===");
		System.out.println(member==null?"조회된 회원이 없습니다":member);
	}
	public void printMemberName(ArrayList<Member> member) {
		System.out.println("==이름으로 조회==");
		for(Member m: member) {
			System.out.println(m);
		}
	}
	public String inputId(String title) {
		System.out.println("=="+title+" 입력===");
		System.out.print(title+ " : ");
		String text=sc.nextLine();
		return text;
		
	}
	public boolean checkMemberId(Member member) {
		System.out.println("===조회된  회원===");
		if(member==null) {
			System.out.println("조회된 회원이 없습니다");
			return false;
		}
		System.out.println(member);
		return true;
	
		
	}
	public Member updateMember() {
		Member m=new Member();
		System.out.println("====회원정보 수정====");
		System.out.println("수정할 정보입력");
		System.out.print("수정할 아이디 입력 : ");
		m.setMemberId(sc.nextLine());
		System.out.print("이름 입력 : ");
		m.setMemberName(sc.nextLine());
		System.out.print("나이 입력: ");
		m.setAge(sc.nextInt());
		sc.nextLine();
		System.out.print("전화 번호입력: ");
		m.setPhone(sc.nextLine());
		System.out.print("이메일 입력: ");
		m.setEmail(sc.nextLine());
		return m;
		
	}
	public Member deleteMember() {
		Member m=new Member();
		System.out.println("==회원 삭제==");
		System.out.print("삭제 할 회원 아이디: ");
		m.setMemberId(sc.nextLine());
		return m;
	}
	public Member insertMember() {
		Member m=new Member();
		System.out.println("==회원등록====");
		System.out.print("아이디 : ");
		m.setMemberId(sc.nextLine());
		System.out.print("비밀번호 : ");
		m.setMemberPwd(sc.nextLine());
		System.out.print("이름 : ");
		m.setMemberName(sc.nextLine());
		System.out.print("성별 (M/F): ");
		String gender=sc.nextLine();
		while(true) {
			if(gender.equals("M")||gender.equals("F")) {
				m.setGender(gender);	
				break;
			}
			System.out.print("성별은 M 또는 F 입력! 다시입력하세요");
		}
		System.out.print("나이 : ");
		m.setAge(sc.nextInt());
		sc.nextLine();
		System.out.print("이메일 : ");
		m.setEmail(sc.nextLine());
		System.out.print("휴대폰 번호 : ");
		m.setPhone(sc.nextLine());
		System.out.print("주소 : ");
		m.setAddress(sc.nextLine());
		System.out.print("취미 (, 으로 구분): ");
		m.setHobby(sc.nextLine());
		return m;
	}
	public void printMsg(String msg) {
		System.out.println("===시스템 메세지===");
		System.out.println(msg);
	}
	
}
