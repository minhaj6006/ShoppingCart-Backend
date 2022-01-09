package com.shoppingCart.products.repository;

import java.util.List;

import com.shoppingCart.products.model.Products;

public interface IProductsRepository {

	public List<Products> getAllProductDB();

	public List<Products> getProductByCategoryDB(String categoryName);

//	public List<Products> getProductByKeywordDB(String keyword);
}
