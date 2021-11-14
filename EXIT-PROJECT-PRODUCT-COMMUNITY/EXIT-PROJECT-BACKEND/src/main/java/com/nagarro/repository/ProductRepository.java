package com.nagarro.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findAllByProductName(String name);

	Product findAllByProductCode(String name);

	List<Product> findAllByProductBrand(String name);

	Product findAllById(int name);

}
