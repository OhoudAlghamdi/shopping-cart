package com.ohoud.cart.shopping_cart.model;
//package com.ohoud.cart.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ohoud_alghamdi_cart_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

    private String name;
    private String description;
    private double price;
    private double taxRate;
    private int quantity;

    // Constructors
    public Product() {
    }

    public Product(String name, String description, double price, double taxRate, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.taxRate = taxRate;
        this.quantity = quantity;
    }

    // Getters and Setters
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}