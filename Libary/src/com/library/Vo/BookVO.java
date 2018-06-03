package com.library.Vo;

public class BookVO {

	private int num;
	private String title;
	private String category;
	private String author;
	private String publisher;
	private String publication_Day;
	private int borrow_Idnum ;
	private String borrow_Day = null;
	private int Borrow = 0;
	
	public BookVO() {}
	
	public BookVO(String title, String category, String author, String publisher, String publication_day)
	{
		this.title = title;
		this.category = category;
		this.author = author;
		this.publisher = publisher;
		this.publication_Day = publication_day;
	}
	
	public BookVO(String title, String category, String author, String publisher, String publication_day, int num)
	{
		this.title = title;
		this.category = category;
		this.author = author;
		this.publisher = publisher;
		this.publication_Day = publication_day;
		this.num = num;
	}


	public BookVO(int borrow_Idnum, String borrow_Day)
	{
		this.borrow_Idnum = borrow_Idnum;
		this.borrow_Day = borrow_Day;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublication_Day() {
		return publication_Day;
	}

	public void setPublication_Day(String publication_Day) {
		this.publication_Day = publication_Day;
	}

	public int getNum() {
		return num;
	}

	public int getBorrow() {
		return Borrow;
	}

	public void setBorrow(int borrow) {
		Borrow = borrow;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public int getBorrow_Idnum() {
		return borrow_Idnum;
	}

	public void setBorrow_Idnum(int borrow_idnum) {
		this.borrow_Idnum = borrow_idnum;
	}

	public String getBorrow_Day() {
		return borrow_Day;
	}

	public void setBorrow_Day(String borrow_Day) {
		this.borrow_Day = borrow_Day;
	}
	
}
