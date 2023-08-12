package com.SpringBootCURDApplication.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookStore {

	private int bookID;
	private String bookName;
	private String bookAuthor;
	private int bookPrice;
	
	@Id
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	public BookStore(int bookID, String bookName, String bookAuthor, int bookPrice) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
	}
	
	public BookStore() {
		super();
		
	}
	
	
}
