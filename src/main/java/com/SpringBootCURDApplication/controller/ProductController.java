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


import com.SpringBootCURDApplication.entity.Product;
import com.SpringBootCURDApplication.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService ps;
	
	@GetMapping("/allproduct")
	public List<Product> getAllProducts() {
		return ps.getAllProducts();
	}

	@PostMapping("saveproduct")
	public String saveProduct(@RequestBody Product product) {
		return ps.saveProduct(product);
	}

	@PutMapping("/product/{id}")
	public String UpdateProduct(@PathVariable int id,@RequestBody Product product) {
		product.setProductId(id);
		return ps.UpdateProduct(product);
	}

	@DeleteMapping("product/{id}")
	public String DeleteProduct(@PathVariable("id") int id) {
		return ps.DeleteProduct(id);
	}


}
