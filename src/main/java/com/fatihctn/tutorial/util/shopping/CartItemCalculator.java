package com.fatihctn.tutorial.util.shopping;

import com.fatihctn.tutorial.domain.entity.CartItem;
import com.fatihctn.tutorial.util.Calculator;

public class CartItemCalculator implements Calculator<CartItem, Double> {

    @Override
    public Double calculateFor(CartItem item) {
        return item.getProduct().getPrice() * item.getQty();
    }
}
