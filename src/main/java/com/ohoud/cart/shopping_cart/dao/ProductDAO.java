package com.ohoud.cart.shopping_cart.dao;

import com.ohoud.cart.shopping_cart.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class ProductDAO {
    private final List<Product> products = new ArrayList<>();
    private int nextId = 1;

    public void save(Product product) {
        if (product.getId() == null) {
            product.setId(nextId++);
        }
        products.add(product);
    }

    public List<Product> findAll() {
        return products;
    }

    public Product findById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    public List<Product> searchByName(String name) {
        return products.stream()
            .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
            .collect(Collectors.toList());
    }

    public boolean delete(int id) {
        return products.removeIf(p -> p.getId() == id);
    }

    public boolean update(int id, Product updatedProduct) {
        for (Product p : products) {
            if (p.getId() == id) {   
            	System.out.println("Updating product: " + id);
            	
                p.setName(updatedProduct.getName());
                p.setDescription(updatedProduct.getDescription());
                p.setPrice(updatedProduct.getPrice());
                p.setTaxRate(updatedProduct.getTaxRate());
                p.setQuantity(updatedProduct.getQuantity());
                return true;
            }
        }
        System.out.println("Product not found for update: " + id);

        return false;
    }
}