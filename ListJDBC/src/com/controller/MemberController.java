package com.controller;

import java.util.List;

import com.model.vo.Board;
import com.model.vo.Emp;
import com.service.MemberService;
import com.view.MainView;



public class MemberController {
	private MemberService service = new MemberService();

	public void searchMemberAll() {
		List<Emp> list = service.searchMemberAll();
		new MainView().printMember(list);

	}

	public void insertMember() {
		Emp ep = new MainView().insertMember();
		int result = service.insertMember(ep);
		new MainView().printMsg(result > 0 ? "회원가입  완료" : "회원가입 실패");

	}

	public void searchMemberId() {
		String userid = new MainView().inputData("아이디");
		List<Emp> list = service.searchMemberId(userid);
		new MainView().printMember(list);
	}

	public void searchMemberName() {
		String userName = new MainView().inputData("이름");
		List<Emp> list = service.searchMemberName(userName);
		new MainView().printMember(list);
	}

	public void deleteMember() {
		Emp e = new MainView().deleteMember();
		int result = service.deleteMember(e);
		new MainView().printMsg(result > 0 ? "회원탈퇴  완료" : "회원탈퇴 실패");

	}

	public void updateMeber() {
		Emp e = new MainView().updateMember();
		int result = service.updateMember(e);
		new MainView().printMsg(result > 0 ? "회원수정  완료" : "회원수정 실패");
	}

	public void searchboardAll() {
		List<Board> blist=service.searchboardAll();
		new MainView().printBoard(blist);
		
	}

	public void insertboard() {
		Board bo=new MainView().insertboard();
		int result=service.insertboard(bo);
		new MainView().printMsg(result > 0 ? "게시물등록  완료" : "게시물등록 실패");
		
	}

	public void delteboard() {
		Board bo=new MainView().deleteboard();
		int result=service.deleteboard(bo);
		new MainView().printMsg(result > 0 ? "게시물삭제  완료" : "게시물삭제 실패");
		
		
	}

	public void searchboardwriter() {
		String writer=new MainView().inputTitle("작성자");
		List<Board>list=service.searchwriter(writer);
		new MainView().printBoard(list);
		
	}
	public void searchboardtitle() {
		String title=new MainView().inputTitle("제목");
		List<Board>list=service.searchboardtitle(title);
		new MainView().printBoard(list);
		
		
	}

	public void updateboard() {
		Board upno=new MainView().updateboard();
		int result=service.updateboard(upno);
		new MainView().printMsg(result > 0 ? "게시물수정  완료" : "게시물수정 실패");
		
		
	}

}
