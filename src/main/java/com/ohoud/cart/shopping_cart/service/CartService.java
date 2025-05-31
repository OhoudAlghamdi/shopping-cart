package com.ohoud.cart.shopping_cart.service;

import com.ohoud.cart.shopping_cart.dao.ProductDAO;
import com.ohoud.cart.shopping_cart.model.Cart;
import com.ohoud.cart.shopping_cart.model.Order;
import com.ohoud.cart.shopping_cart.model.OrderItem;
import com.ohoud.cart.shopping_cart.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CartService {

    private Cart cart = new Cart();

    @Autowired
    private ProductDAO productDAO;

    public void addProduct(int productId, int quantity) {
        Product product = productDAO.findById(productId);
        if (product != null) {
            cart.addItem(product, quantity);
        }
    }
    
    public Order checkout() {
        List<OrderItem> orderItems = cart.getItems().stream()
        		.map(item -> new OrderItem(
        				item.getProduct()
        				.getName(),
        				item.getQuantity()
        				,item.getSubtotal()
        				))
        		.collect(Collectors.toList());

        double total = cart.getTotal();

        Order order = new Order(orderItems, total);
        cart.clear(); 

        return order;
    }
    
    
    public Cart getCart() {
        return cart;
    }

    public void clearCart() {
        cart.clear();
    }
}