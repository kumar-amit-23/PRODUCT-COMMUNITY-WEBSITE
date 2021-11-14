package com.nagarro.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String productName;
	private String productCode;
	private String productBrand;
	@Column(length = 5000)
	private String url;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pc_fid", referencedColumnName = "id")
	private List<Comment> productReview = new ArrayList<>();

	public String getProductName() {
		return productName;
	}

	public Product() {

	}

	public Product(String productName, String productCode, String productBrand, String url) {
		super();
		this.productName = productName;
		this.productCode = productCode;
		this.productBrand = productBrand;
		this.url = url;
	}

	public List<Comment> getProductReview() {
		return productReview;
	}

	public void setProductReview(List<Comment> productReview) {
		this.productReview = productReview;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productCode=" + productCode + ", productBrand="
				+ productBrand + "]";
	}

}
