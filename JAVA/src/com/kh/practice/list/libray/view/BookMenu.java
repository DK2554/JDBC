package com.kh.practice.list.libray.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.practice.list.libray.controller.Bookcontroller;
import com.kh.practice.list.libray.modeol.vo.Book;

public class BookMenu {
	private Scanner sc = new Scanner(System.in);
	private Bookcontroller bc = new Bookcontroller();
	// 생성자를 클래스에 작성하지 않으면
	// 클래스에 필수!! 무조건
	// 생서자 코드를 작성하지 않으면.. 자동으로 생성
	// complie 시점에 자동으로 default 생성자->멤버변수를 기본값
	// 초기화 하는 생성자 생성

	public void mainMenu() {
		// 사용자가 직접메인메뉴를 선택할 수 있다.
		// 종료전까지 반복 실행해야함.->for,whil 무한반복
		// 사용자가 선택한 메뉴에 해당하는 메소드로 이동
		// 사용자가 선택한 기능이 실행될 수 있게 처리
		while (true) {
			System.out.println("==Welcome KH Libray ==");
			System.out.println("***** 메인메뉴 ******");
			System.out.println("1. 새 도서 추가");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색 조회");
			System.out.println("4. 도서 삭제");
			System.out.println("5. 도서 명 오름차순 정렬");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 : ");
			int cho = sc.nextInt();
			sc.nextLine();
			switch (cho) {
			case 1:
				insertBook();
				break;
			case 2:
				selectList();
				break;
			case 3:
				searchBook();
				break;
			case 4:
				deleteBook();
				break;
			case 5:
				ascBook();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}

	}

	public void insertBook() {
		// 도서추가를 위해 정보를 받는 메소드
		// 사용자 한테 도서에 대한 데이터를 받는 메소드
		System.out.println("===도서 입력===");
		System.out.print("도서명 : ");
		String title = sc.nextLine();
		System.out.print("저자명 : ");
		String author = sc.nextLine();
		System.out.print("장르(1.입문/2.자연과학/3.의료/4.기타) : ");
		int gener = sc.nextInt();
		String categor = "";
		switch (gener) {
		case 1:
			categor = "인문";
			break;
		case 2:
			categor = "자연과학";
			break;
		case 3:
			categor = "의료";
			break;
		case 4:
			categor = "기타";
			break;
		}
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		Book bk = new Book(title, author, categor, price);
		// 변수의 생존주기
		// 지역/매개변수,멤버변수,클래스변수
		bc.insertBook(bk);

	}

	public void selectList() {
		// 전체도서 목록을 출력,성공을 알리는 메소드
		ArrayList<Book> bookList = bc.selectList();
		// if(bookList.isEmpty())
		if (bookList.size() == 0) {
			// 저장된 값이 없는것
			System.out.println("존재하는 도서가 없습니다");
		} else {
			for (Book b : bookList) {
				System.out.println(b);
			}
		}

	}

	public void searchBook() {
		//특정도서 검색결과를 보여주는 메소드
		System.out.println("====도서검색=====");
		System.out.print("키워드 입력 : ");
		String keyword=sc.nextLine();
		ArrayList<Book>searchList=bc.searchBook(keyword);
		if(searchList.isEmpty()) {
			System.out.println("검색 결과가 없습니다.");
			
		}else {
			for(Book b:searchList) {
				System.out.println(b);
			}
		}

	}
	public void deleteBook() {
		System.out.println("====== 도서 삭제====");
		System.out.print("삭제할 도서명 : ");
		String title=sc.nextLine();
		System.out.print("삭제할 저자명 : ");
		String author=sc.nextLine();
		Book deleteBook=bc.deleteBook(title, author);
		if(deleteBook==null) {
			System.out.println("삭제할 도서를 찾지 못했습니다.");	
		}else {
			System.out.println("성공적으로 삭제 되었습니다.");
		}
	}

	public void ascBook() {
		int result=bc.ascBook();
		if(result==1) {
			System.out.println("정렬에 성공했습니다. ");	
		}else {
			System.out.println("정렬에 실패했습니다. ");
		}

	}

}
