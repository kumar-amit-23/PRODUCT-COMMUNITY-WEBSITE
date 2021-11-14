package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.nagarro.model.Product;
import com.nagarro.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping("/products")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Product> listAllProducts() {
		return service.findAllProducts();
	}

	@PutMapping("/product")
	@CrossOrigin(origins = "http://localhost:4200")
	public Product updataProduct(@RequestBody Product product) {
		return this.service.updateProduct(product);
	}

	@GetMapping("/totalProducts")
	@CrossOrigin(origins = "http://localhost:4200")
	public int totalProducts() {
		return service.getAllProducts();
	}

	@PostMapping("/saveproducts")
	@CrossOrigin(origins = "http://localhost:4200")
	public Product saveProduct(@RequestBody Product product) throws Exception {
		String productCode = product.getProductCode();
		if (productCode != null || !"".equals(productCode)) {
			Product obj = service.findProductByCode(productCode);
			// System.out.println(obj);
			if (obj != null)
				throw new Exception("User with this " + productCode + " already exists!!");
		}
		return service.saveProduct(product);
	}

	@GetMapping("/products/{name}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Product findProductByName(@PathVariable("name") int name) {
		return service.findProductByName(name);
	}


}
