package com.kh.practice.list.libray.modeol.vo;

import java.util.Objects;

public class Book implements Comparable<Book>{
	private String title;
	private String author;
	private String category;
	private int price;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String author, String category, int price) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "(" + title + "/" + author + "/" + category + "/" + price + ")";
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		//동일한 값을 가지고 있는 객체에 대해
		//동일한 주소값을 반환하게 하는 기능
		
		return Objects.hash(title,author);
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Book) {
			Book b=(Book)obj;
			if(this.title.equals(b.title)&&
					this.author.equals(b.author)) {
				return true;
			}
		}
		return false;
	}
	//CompareTo
	//comparator, comparable
	//comparator->compare->매개변수 비교할 객체 두개를 받음
	//comparable->compareTo메소드 구현 - 매개변수 한개 받음
	//구현된 클래스를 비교할 때 사용하는 메소드
	@Override 
	public int compareTo(Book b) {
		return title.compareTo(b.title);//0,-1,1
		
	}
	

}
