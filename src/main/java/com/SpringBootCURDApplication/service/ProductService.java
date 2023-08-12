package com.SpringBootCURDApplication.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootCURDApplication.dao.ProductDao;
import com.SpringBootCURDApplication.entity.Product;


@Service
public class ProductService {

	@Autowired
	private ProductDao pd;
	
	public List<Product> getAllProducts() {
		return pd.getAllProducts();
	}

	public String saveProduct(Product product) {
		return pd.saveProduct(product);
	}

	public String UpdateProduct(Product product) {
		return pd.UpdateProduct(product);
	}

	public String DeleteProduct(int id) {
		return pd.DeleteProduct(id);
	}

}
