package com.product.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.product.api.models.Product;


@Service
public class ProductService {
	
	public List<Product> getAllProducts(){
		List<Product> listOfProducts= new ArrayList<>();
		listOfProducts.add(new Product("123", "IPHONE X", "this is an awesome Iphone",299.99, "Apple"));
		listOfProducts.add(new Product("124", "Samsung", "this is an awesome Samsung",199.99, "Samsung Galaxy"));
		listOfProducts.add(new Product("125", "LG Z", "this is an awesome lg phone",99.99, "LG LLC"));
		return listOfProducts;
	}
	
	public Product getProductById(String id) {
		Product res=null;
		List<Product> products =getAllProducts();
		for(int i =0; i<products.size();i++) {
			if(products.get(i).getId().equals(id)) {
				res=products.get(i);
			}
		}
		return res;
	}
	
	public Product addProduct(Product newProduct) {
		newProduct.setId("126");
		return newProduct;
	}
}
