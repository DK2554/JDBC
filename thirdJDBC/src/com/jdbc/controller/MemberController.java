package com.jdbc.controller;

import java.util.ArrayList;
import java.util.List;

import com.jdbc.model.servie.MemberService;
import com.jdbc.model.vo.Member;
import com.jdbc.view.MainView;

public class MemberController {

	// dao에 요청을 하는것이 아니라 service객체에 요청으 하게 됨
	private MemberService service = new MemberService();// Connection생성,트렌젝션관리

	public void mainMenu() {
		new MainView().mainMenu();
	}

	public void searchMemberAll() {
		List<Member> list = service.searchMemberAll();
		new MainView().printMember(list);
	}

	public void searchMemberName() {
		String userName = new MainView().inputId("이름");
		List<Member> member = service.searchMemberName(userName);
		new MainView().print(member, "이름");

	}

	public void insertMember() {
		Member member = new MainView().insertMember();
		int result = service.insertMember(member);
		new MainView().printMsg(result > 0 ? "회원등록완료 " : "회원등록 실패");

	}

	public void searchMemberId() {
		String userId = new MainView().inputId("아이디");
		List<Member> mlist = service.searchMEmberId(userId);
		new MainView().print(mlist, "아이디");

	}

	public void updateMeber() {
		// 전체회원을 먼저 출력해주는것이 좋은 방법

		Member upmember = new MainView().updateMember();
		int result = service.updateMember(upmember);
		new MainView().printMsg(result > 0 ? "회원수정 완료" : "회원수정  실패");

	}

	public void deleteMember() {
		Member m=new MainView().deleteMember();
		int result=service.deleteMember(m);
		
		if(result>0) new MainView().printMsg(result>0?"회원삭제 완료":"회원삭제 실패함");
		}

}
