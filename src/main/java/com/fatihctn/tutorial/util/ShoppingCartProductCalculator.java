package com.fatihctn.tutorial.util;

import com.fatihctn.tutorial.domain.entity.CartItem;
import com.fatihctn.tutorial.domain.entity.Category;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCartProductCalculator implements Calculator<Category, Integer> {

    private List<CartItem> cartItems;

    public ShoppingCartProductCalculator(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public Integer calculateFor(Category category) {
        return this.cartItems.stream()
                .filter(cartItem -> category.equals(cartItem.getProduct().getCategory()))
                .mapToInt(CartItem::getQty).sum();
    }

    public List<CartItem> listCartItemFor(Category category) {
        return this.cartItems.stream()
                .filter(cartItem -> category.equals(cartItem.getProduct().getCategory()))
                .collect(Collectors.toList());
    }
}
