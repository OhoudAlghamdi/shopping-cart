package com.ohoud.cart.shopping_cart.controller;

import com.ohoud.cart.shopping_cart.dao.ProductDAO;
import com.ohoud.cart.shopping_cart.model.Product;
import com.ohoud.cart.shopping_cart.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public List<Product> getAllProducts() {
	    return productRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable int id) {
	    return productRepository.findById(id)
	            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
	}
	
	@PostMapping
	public String addProduct(@RequestBody Product product) {
	    productRepository.save(product);
	    return "Product added successfully";
	}
	
	@PutMapping("/{id}")
	public String updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
	    Product product = productRepository.findById(id)
	            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

	    product.setName(updatedProduct.getName());
	    product.setDescription(updatedProduct.getDescription());
	    product.setPrice(updatedProduct.getPrice());
	    product.setTaxRate(updatedProduct.getTaxRate());
	    product.setQuantity(updatedProduct.getQuantity());

	    productRepository.save(product);
	    return "Product updated";
	}
	
	@GetMapping("/search")
	public List<Product> searchByName(@RequestParam String name) {
	    return productRepository.findByNameContainingIgnoreCase(name);
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable int id) {
	    if (productRepository.existsById(id)) {
	        productRepository.deleteById(id);
	        return "Product deleted";
	    } else {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
	    }
	}
}
