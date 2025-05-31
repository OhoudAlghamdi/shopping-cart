package com.ohoud.cart.shopping_cart.model;

import java.util.List;

public class Order {

    private List<OrderItem> items;
    private double total;

    public Order(List<OrderItem> items, double total) {
        this.items = items;
        this.total = total;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }
}
