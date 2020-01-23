package com.fatihctn.tutorial.service.impl;

import com.fatihctn.tutorial.domain.entity.Campaign;
import com.fatihctn.tutorial.domain.entity.CartItem;
import com.fatihctn.tutorial.domain.entity.Category;
import com.fatihctn.tutorial.domain.entity.Coupon;
import com.fatihctn.tutorial.domain.entity.Product;
import com.fatihctn.tutorial.domain.response.CartItemResponse;
import com.fatihctn.tutorial.domain.response.ShoppingCartResponse;
import com.fatihctn.tutorial.service.ShoppingCart;
import com.fatihctn.tutorial.util.Calculator;
import com.fatihctn.tutorial.util.shopping.CampaignCalculator;
import com.fatihctn.tutorial.util.shopping.CartItemCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShoppingCartImpl implements ShoppingCart {
    private final static Logger logger = LoggerFactory.getLogger(ShoppingCart.class);

    private Set<CartItem> items;

    private Set<Category> uniqueCategories;

    private Set<Product> uniqueProducts;

    private Set<Campaign> campaigns;

    private Campaign campaign;

    private CartItemCalculator cartItemCalculator= new CartItemCalculator();

    private CampaignCalculator campaignCalculator = new CampaignCalculator();

    @Override
    public void addItem(Product product, Integer quantity) {
        this.uniqueCategories.add(product.getCategory());
        this.uniqueProducts.add(product);
        this.items.add(generateCartItem(product, quantity));
        updateCartWithCampaign();
    }

    private void updateCartWithCampaign() {
        detectActiveCampaign();
        if (campaign != null) {
            this.items.stream()
                    .filter(cartItem -> campaign.getCategory().equals(cartItem.getProduct().getCategory()))
                    .forEach(cartItem -> cartItem.setTotalAmountWithCampaign(
                            cartItem.getTotalAmount() - campaignCalculator.calculateItemFor(cartItem, campaign)
                    ));
        }
    }

    private void detectActiveCampaign() {
        getCampaignDiscount();
        this.campaign = campaignCalculator.getActualCampaign();
    }

    private CartItem generateCartItem(Product product, Integer qty) {
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQty(qty);
        cartItem.setTotalAmount(cartItemCalculator.calculateFor(cartItem));
        return cartItem;
    }

    public Set<Category> getUniqueCategories() {
        return uniqueCategories;
    }


    public Set<Product> getUniqueProducts() {
        return uniqueProducts;
    }

    private Integer getNumberOfCategories() {
        return this.uniqueCategories.size();
    }

    public Integer getNumberOfProducts() {
        return this.uniqueProducts.size();
    }

    @Override
    public Double getTotalAmount() {
        Double totalAmount = 0.00D;
        for (CartItem cartItem: items) {
            totalAmount += cartItem.getTotalAmount();
        }
        return totalAmount;
    }

    @Override
    public Double getCampaignDiscount() {
        return campaignCalculator.calculateFor(this);
    }

    @Override
    public Double getTotalAmountAfterDiscounts() {
        return getTotalAmount() - getCampaignDiscount();
    }

    public ShoppingCartResponse getDetails() {
        ShoppingCartResponse cartResponse = new ShoppingCartResponse();
        cartResponse.setItems(this.items.stream().map(this::generateCartItemToResponse).collect(Collectors.toList()));
        cartResponse.setTotalPrice(getTotalAmount());
        return cartResponse;
    }

    @Override
    public void applyCampaign(Campaign campaign) {
        this.campaigns.add(campaign);
    }

    public void applyCampaigns(Campaign... campaigns) {
        this.campaigns.addAll(Arrays.asList(campaigns));
    }

    @Override
    public List<CartItem> getItems() {
        return new ArrayList<>(this.items);
    }

    public List<Campaign> getAppliedCampaigns() {
        return new ArrayList<>(this.campaigns);
    }

    private CartItemResponse generateCartItemToResponse(CartItem cartItem) {
        CartItemResponse cartItemResponse = new CartItemResponse();
        cartItemResponse.setCategoryName(cartItem.getProduct().getCategory().getTitle());
        cartItemResponse.setProductName(cartItem.getProduct().getTitle());
        cartItemResponse.setQuantity(cartItem.getQty());
        cartItemResponse.setTotalPrice(cartItem.getTotalAmount());
        cartItemResponse.setUnitPrice(cartItem.getProduct().getPrice());
        return cartItemResponse;
    }
}
