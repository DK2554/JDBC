package com.view;

import java.util.List;
import java.util.Scanner;

import com.controller.MemberController;
import com.model.vo.Board;
import com.model.vo.Emp;

public class MainView {
	private MemberController controller = new MemberController();

	public void mainMenu() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("메인메뉴=====");
			System.out.println("1.회원 관리");
			System.out.println("2.게시판 관리");
			System.out.println("3.프로그램 종료");
			System.out.print("입력 :");
			switch (sc.nextInt()) {
			case 1:
				member();
				break;
			case 2:
				board();
				break;
			case 3:
				return;

			}
		}

	}

	public void board() {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("1.게시판전체검색");
			System.out.println("2.게시물등록");
			System.out.println("3.작성자로 검색");
			System.out.println("4.제목으로 검색");
			System.out.println("5.게시물 수정(제목,내용)idx로 수정");
			System.out.println("6.게시물 삭제");
			System.out.println("7.메인메뉴로");
			System.out.print("입력 : ");
			switch (sc.nextInt()) {
			case 1:
				controller.searchboardAll();
				break;
			case 2:
				controller.insertboard();
				break;
			case 3:
				controller.searchboardwriter();
				break;
			case 4:
				controller.searchboardtitle();
				break;
			case 5:
				controller.updateboard();
				break;
			case 6:
				controller.delteboard();
				break;

			case 7:
				return;
			}

		}

	}

	public void member() {
		Scanner sc = new Scanner(System.in);
		while (true) {

			System.out.println("1.전체회원 조회");
			System.out.println("2.회원 아이디로 조회");
			System.out.println("3.회원 이름으로 조회");
			System.out.println("4.회원가입");
			System.out.println("5.회원정보수정(주소,전화번호,이메일)");
			System.out.println("6.회원탈퇴");
			System.out.println("7.메인메뉴로");
			System.out.print("입력 : ");
			switch (sc.nextInt()) {
			case 1:
				controller.searchMemberAll();
				break;
			case 2:
				controller.searchMemberId();
				break;
			case 3:
				controller.searchMemberName();
				break;
			case 4:
				controller.insertMember();
				break;
			case 5:
				controller.updateMeber();
				break;
			case 6:
				controller.deleteMember();
				break;
			case 7:
				return;

			}
		}

	}

	public void printMember(List<Emp> list) {
		System.out.println("회원 조회 결과");
		System.out.println("=======================");
		for (Emp m : list) {
			System.out.println(m);
		}

	}

	public Board insertboard() {
		Scanner sc = new Scanner(System.in);
		Board bo = new Board();
		System.out.println("===게시물 등록하기====");
		System.out.print("게시물 종류('공지','일반','비밀') : ");
		bo.setDiv(sc.nextLine());
		System.out.print("게시물 제목 : ");
		bo.setTitle(sc.nextLine());
		System.out.print("내용입력 :");
		bo.setComent(sc.nextLine());
		System.out.print("작성자 : ");
		bo.setWriter(sc.nextLine());
		return bo;
	}

	public Emp insertMember() {
		Scanner sc = new Scanner(System.in);
		Emp em = new Emp();
		System.out.println("======회원 가입 입력 창 ======");
		System.out.print("회원 아이디 입력 :");
		em.setMemberId(sc.nextLine());
		System.out.print("회원 패스워드입력 : ");
		em.setMemberPwd(sc.nextLine());
		System.out.print("회원 이름 입력 : ");
		em.setMemberName(sc.nextLine());
		System.out.print("이메일 입력 : ");
		em.setEmail(sc.nextLine());
		System.out.print("주소 입력 : ");
		em.setAddress(sc.nextLine());
		System.out.print("전화번호 입력 : ");
		em.setPhone(sc.nextLine());
		return em;
	}

	public void printMsg(String msg) {
		System.out.println("==========");
		System.out.println(msg);

	}

	public String inputData(String string) {
		Scanner sc = new Scanner(System.in);
		System.out.println("조회하실 " + string + " 입력해주세요 ");
		System.out.print("입력 : ");
		return sc.nextLine();
	}

	public Emp deleteMember() {
		Scanner sc = new Scanner(System.in);
		Emp m = new Emp();
		System.out.println("삭제할 아이디를 입력해주세요");
		System.out.print("입력 :");
		m.setMemberId(sc.nextLine());
		return m;
	}

	public Emp updateMember() {
		Scanner sc = new Scanner(System.in);
		Emp m = new Emp();
		System.out.println("수정할 아이디를 입력해주세요");
		System.out.print("입력 : ");
		m.setMemberId(sc.nextLine());
		System.out.print("주소 입력 : ");
		m.setAddress(sc.nextLine());
		System.out.print("전화번호 입력 : ");
		m.setPhone(sc.nextLine());
		System.out.print("이메일 입력 : ");
		m.setEmail(sc.nextLine());
		return m;

	}

	public void printBoard(List<Board> blist) {
		System.out.print("게시판 ");
		System.out.println("=======================");
		for (Board b : blist) {
			System.out.println(b);
		}

	}

	public Board deleteboard() {
		Scanner sc = new Scanner(System.in);
		Board bo = new Board();
		System.out.println("=====게시물삭제 ======");
		System.out.println("삭제할 게시물의 작성자를 입력해주세요");
		System.out.print("작성자 : ");
		bo.setWriter(sc.nextLine());
		return bo;

	}

	public String inputTitle(String string) {
		Scanner sc = new Scanner(System.in);
		System.out.println("===" + string + "으로 입력받기=====");
		System.out.print(string + "을 입력해주세요 : ");
		return sc.nextLine();
	}

	public Board updateboard() {
		Scanner sc = new Scanner(System.in);
		Board b = new Board();
		System.out.println("전체게시물 조회");
		controller.searchboardAll();
		System.out.println("수정할  게시물 번호를 입력해주세요");
		System.out.print("입력 : ");
		b.setBoard_no(sc.nextInt());
		sc.nextLine();
		System.out.print("수정할 제목을 입력하세요:");
		b.setTitle(sc.nextLine());
		System.out.print("수정할 내용을 입력하세요 : ");
		b.setComent(sc.nextLine());
		return b;
	}

}
