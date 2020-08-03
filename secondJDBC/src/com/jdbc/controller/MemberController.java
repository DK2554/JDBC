package com.jdbc.controller;

import java.util.ArrayList;

import com.jdbc.model.dao.MemberDao;
import com.jdbc.model.vo.Member;
import com.jdbc.view.MainView;

public class MemberController {
	//기능 제공용 클래스
	private MemberDao dao=new MemberDao();
	//mainMenu 연결하는 메소드
	public void mainMenu() {
		//view패키지에 있는 main화면 출력 기능을 호출
		new MainView().mainMenu();
	}
	//member 테이블의 전체회원을 조회하는 서비스
	public void searchMemberAll() {
		//DB에 가서 member 테이블에 있는 회원을 받아 와서(model) 
		//받아온 회원을 출력(view)하게 해주는 서비스
		//Dao가 보내준 데이터 받기
		ArrayList<Member> members=dao.searchMemberAll();
		//받은데이터를 멤버를 client에게 출력하기
		new MainView().printMember(members);
		
	}
	public void searchMemberId() {
		//1. ID값 받기
		String userId=new MainView().inputId("아이디");
		//2. ID을 dao에 전달하여 DB에 있는 데이터를 가져옴
		Member member=dao.searchMemberId(userId);
		new MainView().printMemberId(member);
		
	}
	public void searchMemberName() {
		String userName=new MainView().inputId("이름");
		ArrayList<Member> member=dao.searchMemberName(userName);
		new MainView().printMember(member);
		
	}
	public void insertMember() {
		Member m=new MainView().insertMember();
		int result=dao.insertMember(m);
		new MainView().printMsg(result>0?"회원가입 성공":"회원가입실패");
		
	}
	public void updateMember() {
		//일단 해당 회원이 있는지 조회
		String userId=new MainView().inputId("아이디");
		Member member=dao.searchMemberId(userId);
		boolean ch=new MainView().checkMemberId(member);
		if(ch) {
			Member upmember=new MainView().updateMember();
			int result=dao.updateMember(upmember);
			new MainView().printMsg(result>0?"업데이트성공":"업데이트실패");
		}
	}
	public void deleteMember() {
		Member delmember=new MainView().deleteMember();
		int result=dao.deleteMember(delmember);
		new MainView().printMsg(result>0?"삭제성공":"삭제실패");
	}
}
