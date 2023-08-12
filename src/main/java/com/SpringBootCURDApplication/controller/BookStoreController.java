package com.SpringBootCURDApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootCURDApplication.entity.BookStore;
import com.SpringBootCURDApplication.service.BookStoreService;

@RestController
public class BookStoreController {

	@Autowired
	private BookStoreService bs;
	
	@GetMapping("/allBooks")
	public List<BookStore> getAllBooks()
	{
		return bs.getAllBooks();
	}
	
	public List<BookStore> getBookByPriceLessThan(int price) {
		return bs.getBookByPriceLessThan(price);
	}
	
	@PostMapping("/saveBook")
	public String SaveNewBook(BookStore book) {
		return bs.SaveNewBook(book);
	}
	
	@PutMapping("/updateBook/{id}")
	public String UpdateBook(@PathVariable int id,@RequestBody BookStore book) {
		return bs.UpdateBook(book);
	}
	
	@DeleteMapping("{id}")
	public String DeleteBook(@PathVariable("id")int id) {
		return bs.DeleteBook(id);
	}
}
