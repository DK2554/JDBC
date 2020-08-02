package com.kh.practice.list.libray.run;

import com.kh.practice.list.libray.view.BookMenu;

public class Run {
	public static void main(String[] args) {
		//객체생성->클래스코드를 메모리공간에 할당을 하는 작업
		//생성-?new 객체명()
		//BookMenu클래스를 생성
		BookMenu menu=new BookMenu();//BookMenu클래스를 생성
		//클래스 코드 상태에서 사용이 불가능
		//프로그램이 돌아갈때는 RAM공간에 데이터가 있어야 가능!!
		menu.mainMenu();
	}
}
