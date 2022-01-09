package com.shoppingCart.products.service;

import java.util.List;

import com.shoppingCart.products.model.Products;

public interface IProductsService {

	public List<Products> getAllProduct();

	public List<Products> getProductByCategory(String categoryName);

//	public List<Products> getProductByKeyword(String keyword);
}
