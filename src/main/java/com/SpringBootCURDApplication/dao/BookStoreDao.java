package com.SpringBootCURDApplication.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SpringBootCURDApplication.entity.BookStore;

@Repository
public class BookStoreDao {

	@Autowired
	private SessionFactory sf;
	
	public List<BookStore> getAllBooks() {
			Session session =sf.openSession();
			Transaction tr =session.beginTransaction();
			Criteria crt =session.createCriteria(BookStore.class);
			List<BookStore> books =crt.list();
			tr.commit();
			return books;
		}

	public List<BookStore> getBookByPriceLessThan(int price) {
		Session session =sf.openSession();
		Transaction tr =session.beginTransaction();
		Criteria crt =session.createCriteria(BookStore.class);
		crt.add(Restrictions.lt("bookPrice", price));
		List<BookStore> books =crt.list();
		tr.commit();
		return books;
	}

	public String SaveNewBook(BookStore book) {
		Session session =sf.openSession();
		Transaction tr =session.beginTransaction();
		session.save(book);
		tr.commit();
		return "book saved";
	}

	public String UpdateBook(BookStore book) {
		Session session =sf.openSession();
		Transaction tr =session.beginTransaction();
		try {
			session.update(book);
			tr.commit();
			return "book update";
		} catch (Exception e) {
			return "Book of this id is not present, please enter again";
		}
	}

	public String DeleteBook(int id) {
		Session session =sf.openSession();
		Transaction tr =session.beginTransaction();
		BookStore book =session.get(BookStore.class, id);
		try {
			session.delete(book);
			tr.commit();
			return "book delete";
		} catch (Exception e) {
			return "Book of this id is not present, please enter again";
		}
	}
	}


