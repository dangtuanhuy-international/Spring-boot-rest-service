package com.eid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eid.entity.Product;
import com.eid.exception.ResourceNotFoundException;
import com.eid.handleconst.HandleConstError;
import com.eid.repository.ProductRepository;

@RestController
@RequestMapping("eid/products")
public class ProductController {
	@Autowired
	private ProductRepository productRepositoty;

	@GetMapping
	public List<Product> getAllProducts() {
		return this.productRepositoty.findAll();
	}

	@GetMapping("/{id}")
	public Product getUserById(@PathVariable(value = "id") long productId) {
		return this.productRepositoty.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException(HandleConstError.PRODUCT_NOT_FOUND + productId));
	}

	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return this.productRepositoty.save(product);
	}

	@PutMapping("/{id}")
	public Product updateProduct(@RequestBody Product product, @PathVariable("id") long productId) {
		Product existingProduct = this.productRepositoty.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException(HandleConstError.PRODUCT_NOT_FOUND + productId));
		existingProduct.setProductName(product.getProductName());
		existingProduct.setProductAddress(product.getProductAddress());
		existingProduct.setProductDetails(product.getProductDetails());
		return this.productRepositoty.save(existingProduct);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("id") long productId) {
		Product existingProduct = this.productRepositoty.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException(HandleConstError.PRODUCT_NOT_FOUND + productId));
		this.productRepositoty.delete(existingProduct);
		return ResponseEntity.ok().build();
	}
}
