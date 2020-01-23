package com.fatihctn.tutorial.service;

import com.fatihctn.tutorial.domain.entity.Product;
import com.fatihctn.tutorial.domain.response.ShoppingCartResponse;

public interface ShoppingCart {

    public abstract void addItem(Product product, Integer quantity);

    public abstract Double getTotalAmount();

    public abstract ShoppingCartResponse getDetails();

}
