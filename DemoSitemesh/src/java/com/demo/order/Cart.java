/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.order;

import java.math.BigInteger;
import java.util.HashMap;

/**
 *
 * @author Gunner
 */
public class Cart {

    private HashMap<String, OrderDetails> cart;
    private BigInteger total;
    private String username;
    private Integer size;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public HashMap<String, OrderDetails> getCart() {
        return cart;
    }

    public void setCart(HashMap<String, OrderDetails> cart) {
        this.cart = cart;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Cart() {
        cart = new HashMap<String, OrderDetails>();
        total = BigInteger.valueOf(0);
        username = "guest";
    }

    public Cart(HashMap<String, OrderDetails> cart, BigInteger total) {
        this.cart = cart;
        this.total = total;
    }

    public void addToCart(String id, OrderDetails orderDeatil) {
        if (cart.containsKey(id)) {
            Integer oldQuantity = ((OrderDetails) cart.get(id)).getQuantity();
            ((OrderDetails) cart.get(id)).setQuantity(oldQuantity + 1);
        } else {
            cart.put(id, orderDeatil);
        }
        total = total.add((orderDeatil.getPrice()).multiply(BigInteger.valueOf(orderDeatil.quantity.intValue())));
        size = cart.size();
    }

    public boolean removeFromCart(String id) {
        if (cart.containsKey(id)) {
            cart.remove(id);
            return true;
        }
        return false;
    }
}
