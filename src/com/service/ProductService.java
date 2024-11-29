package com.service;

import java.util.List;

import com.model.Product;

public interface ProductService {
	
	void addProduct(Product pd);

	List<Product> getAllProduct();
	List<Product> searchProduct(String data);
	void updateProduct(Product ps);

}
