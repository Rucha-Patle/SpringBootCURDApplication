package com.SpringBootCURDApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootCURDApplication.dao.BookStoreDao;
import com.SpringBootCURDApplication.entity.BookStore;

@Service
public class BookStoreService {

	@Autowired
	private BookStoreDao bd;
	
	public List<BookStore> getAllBooks() {
		return bd.getAllBooks();
	}

	public List<BookStore> getBookByPriceLessThan(int price) {
		return bd.getBookByPriceLessThan(price);
	}

	public String SaveNewBook(BookStore book) {
		return bd.SaveNewBook(book);
	}

	public String UpdateBook(BookStore book) {
		return bd.UpdateBook(book);
	}

	public String DeleteBook(int id) {
		return bd.DeleteBook(id);
	}

}
