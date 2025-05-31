package com.ohoud.cart.shopping_cart;

import com.ohoud.cart.shopping_cart.model.Product;
import com.ohoud.cart.shopping_cart.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    public DataLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {
        if (productRepository.count() == 0) {
            productRepository.save(new Product("Milk", "Fresh milk", 2.5, 0.05, 100));
            productRepository.save(new Product("Bread", "Whole wheat bread", 1.2, 0.05, 200));
            productRepository.save(new Product("Cheese", "Cheddar cheese", 4.0, 0.08, 50));
            productRepository.save(new Product("Eggs", "Pack of 12 eggs", 3.0, 0.05, 80));
            productRepository.save(new Product("Butter", "Organic butter", 5.5, 0.08, 60));
            productRepository.save(new Product("Juice", "Orange juice", 3.5, 0.05, 120));
            productRepository.save(new Product("Cereal", "Corn flakes", 4.8, 0.07, 70));
            productRepository.save(new Product("Yogurt", "Greek yogurt", 2.0, 0.05, 90));
            productRepository.save(new Product("Rice", "Basmati rice 1kg", 6.0, 0.05, 150));
            productRepository.save(new Product("Tomato Sauce", "Organic sauce", 2.2, 0.05, 110));
            productRepository.save(new Product("Pasta", "Whole grain pasta", 2.9, 0.05, 100));
            productRepository.save(new Product("Peanut Butter", "Crunchy peanut butter", 6.5, 0.08, 40));
            productRepository.save(new Product("Milk", "Fresh milk 3L", 6.5, 0.85, 300));


            System.out.println("Sample products loaded.");
        } else {
            System.out.println("Products already exist. Skipping data load.");
        }
    }
}
