package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.model.Product;
import com.nagarro.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	public List<Product> findAllProducts() {
		return repo.findAll();
	}
	
	public  Product saveProduct(Product product) {
		return repo.save(product);
	}
	
	public Product updateProduct(Product product) {
		return repo.save(product);
	}
	
	public int getAllProducts() {
		return repo.findAll().size();
	}
	
	public Product findProductByName(int name) {
		
		return repo.findAllById(name);
	}
	
	public Product findProductByCode(String name) {
		return repo.findAllByProductCode(name);
	}

	public List<Product> findProductByBrand(String name) {
		return repo.findAllByProductBrand(name);
	}
}
