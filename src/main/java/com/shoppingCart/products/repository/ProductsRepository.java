package com.shoppingCart.products.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shoppingCart.products.model.Products;

@Repository
public class ProductsRepository implements IProductsRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Products> getAllProductDB() {
		String SQL = "SELECT * FROM products";
		List<Products> products = jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Products.class));
		return products;
	}

	@Override
	public List<Products> getProductByCategoryDB(String categoryName) {
		String SQL = String.format("SELECT * FROM products WHERE MATCH (pCategory)  AGAINST ('%s') ", categoryName);
		List<Products> products = jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Products.class));
		return products;

	}

//	@Override
//	public List<Products> getProductByKeywordDB(String keyword) {
//		String SQL = String.format("SELECT * FORM products WHERE MATCH (pName, pDesc) AGAINST ('%s')", keyword);
//		List<Products> products = jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Products.class));
//		return products;
//	}
}
