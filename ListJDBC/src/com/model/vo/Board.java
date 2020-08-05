package com.model.vo;

import java.sql.Date;

public class Board {
	private int board_no;
	private String div;
	private String title;
	private String coment;
	private String writer;
	private Date writer_date;

	public Board() {

	}

	public Board(int board_no, String div, String title, String coment, String writer, Date writer_date) {
		super();
		this.board_no = board_no;
		this.div = div;
		this.title = title;
		this.coment = coment;
		this.writer = writer;
		this.writer_date = writer_date;
	}

	@Override
	public String toString() {
		return "Board [board_no=" + board_no + ", div=" + div + ", title=" + title + ", coment=" + coment + ", writer="
				+ writer + ", writer_date=" + writer_date + "]";
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getDiv() {
		return div;
	}

	public void setDiv(String div) {
		this.div = div;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComent() {
		return coment;
	}

	public void setComent(String coment) {
		this.coment = coment;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getWriter_date() {
		return writer_date;
	}

	public void setWriter_date(Date writer_date) {
		this.writer_date = writer_date;
	}

}
