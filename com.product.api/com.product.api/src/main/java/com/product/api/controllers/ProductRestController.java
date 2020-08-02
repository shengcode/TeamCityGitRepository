package com.product.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.models.Product;
import com.product.api.services.ProductService;


@RestController 
public class ProductRestController {
  
	@Autowired
	private ProductService productservice;
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		/* it automactically convert the data to json */
		return productservice.getAllProducts();
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity <Product> getProductById(@PathVariable("id") String productId){
		Product product = productservice.getProductById(productId);
		if (product == null) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Product>(product, HttpStatus.OK);
				
	}
	
}
