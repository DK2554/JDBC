package com.kh.practice.list.libray.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.practice.list.libray.modeol.vo.Book;

public class Bookcontroller {
	//List 구현한 ArrayList();
	//ArrayList 객체들을 저장할 수 있는 배열과 유사한 객체로
	//Object 배열과 달리 추가,삭제,삽입,수정에 대한 로직이 있는 객체
	
	private List list=new ArrayList();
	//생성되는 Book들을 저장하고 관리하는 객체,변수
	//생성자 클래스명이랑 동일한 특수한 메소드
	//생성자는 클래스를 메모리 공간에 할당할때 사용하는 
	//특수한 메소드 반환명X 호출할때마다 heap영역에
	//저장공간 확보함, 메모리공간을 확보하면 GC가 지우거나
	//개발자가 지우는 메소드를 실행 하지 않으면 삭제할 수 없음
	public Bookcontroller() {
		//기본적인 생성자의 기능
		//멤버변수를 초기화 하는것
		list.add(new Book("자바의 정석","남궁성","기타",20000));
		list.add(new Book("쉽게 배우는 알고리즘","문병로","기타",15000));
		list.add(new Book("대화의 기술","강보람","인문",17500));
		list.add(new Book("암 정복기","박신우","의료",21000));
		
	}
	public void insertBook(Book bk) {
		//list에 데이터를 저장하는 기능
		list.add(bk);
		
	}
	public ArrayList selectList() {
		//list->List자료형
		//반환하는 자료형 ArrayList
		//부모자료형,자식자료형으로 될려면->강제 형변환
		
		return (ArrayList)list;
		
	}
	public ArrayList searchBook(String keyword) {
		//keywork값을 포함하고 있는 book찾기
		//list에서 도서명이 keyword를 포함하고 있는 객체 찾기
		//선언 및 생성
		//list에는 여러 book들이 인덱스랑 매칭되어 저장되어있음
		//list에 저장되오 있는 book 순회(일일히 접근해서 비교)
		//list에 저장되어 있는 값 접근하려면
		//get(인덱스)인덱스는 순서대로 0부터 시작한다
		//list.get(0)->첫번째 저장된 Book객체
		//list.get(1)->두번째 저장된 Book객체
		//list.get(0)==book
		//도서명에 접근하려면 list.get(i).getTitle();
		ArrayList searchList=new ArrayList();
		for(Object b:list) {
			//b가 Book인지 확인하기
			//instanceof:부모 변수에 실제 들어가 있는 객체확인->상속관계에 있는 객체	
			if(b instanceof Book) {
				Book temp=(Book)b;
				if(temp.getTitle().contains(keyword)||
						temp.getAuthor().contains(keyword)) {
					searchList.add(temp);
				}
			}
		}
		return searchList;
	}
	public Book deleteBook(String title,String author) {
		//삭제된 도서를 담을 book객체선언 null로 초기화
		//반복문을 통해 bookList의 책중 title이랑 동일하고
		//저자명이 전달받은 author이랑 동일 한 경우 그 인덱스 도서를 삭제
		//삭제한 도서를 반환/
		
	
		Book removeBook=null;
		for(int i=0;i<list.size();i++) {
			if(list.get(i) instanceof Book) {
				Book b=(Book)list.get(i);
				if(b.getTitle().equals(title)&&
						b.getAuthor().equals(author)) {
					//삭제
					//remove메소드
					list.remove(i);
					removeBook=b;
				}
			}
		}
		return removeBook;
	}
	public int ascBook() {
		//오르차순 정렬
		//list정렬
		//Collections.sort(정렬한 리스트)
		Collections.sort(list);
		return 1;
		
		
	}
	
}
