package com.shoppingCart.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingCart.products.model.Products;
import com.shoppingCart.products.repository.IProductsRepository;

@RestController
public class ProductsService implements IProductsService {

	@Autowired
	private IProductsRepository pRepo;

	@Override
	@GetMapping("/products")
	public List<Products> getAllProduct() {
		return pRepo.getAllProductDB();
	}

	@Override
	@GetMapping("products/{categoryName}")
	public List<Products> getProductByCategory(@PathVariable String categoryName) {
		return pRepo.getProductByCategoryDB(categoryName);
	}

//	@Override
//	@GetMapping("/products/{keyword}")
//	public List<Products> getProductByKeyword(@PathVariable String keyword) {
//		return pRepo.getProductByKeywordDB(keyword);
//	}

}
