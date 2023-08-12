package com.SpringBootCURDApplication.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SpringBootCURDApplication.entity.Product;

@Repository
public class ProductDao {

	@Autowired
	private SessionFactory sf;
	
	public List<Product> getAllProducts() {
		Session session=sf.openSession();
		Transaction tr =session.beginTransaction();
		Criteria crt=session.createCriteria(Product.class);
		List<Product> product =crt.list();
		tr.commit();
		return product;
	}

	public String saveProduct(Product product) {
		Session session =sf.openSession();
		Transaction tr =session.beginTransaction();
		session.save(product);
		tr.commit();
		return "Product saved";
	}

	public String UpdateProduct(Product product) {
		Session session=sf.openSession();
		Transaction tr =session.beginTransaction();
		try{session.update(product);
		tr.commit();
		return "product updated";
		}
		catch (Exception e) {
			return "Product of this id is not present, please enter again";
		}
	}

	public String DeleteProduct(int id) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Product product =session.get(Product.class, id);
		try {
			session.delete(product);
			tr.commit();
			return "Product Deleted";
		}
		catch (Exception e) {
			return "Product of this id is not present, please enter again";
		}
	}

}
