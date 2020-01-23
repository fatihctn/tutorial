package com.fatihctn.tutorial.service;

import com.fatihctn.tutorial.domain.entity.Campaign;
import com.fatihctn.tutorial.domain.entity.CartItem;
import com.fatihctn.tutorial.domain.entity.Coupon;
import com.fatihctn.tutorial.domain.entity.Product;
import com.fatihctn.tutorial.domain.response.ShoppingCartResponse;

import java.util.List;

public interface ShoppingCart {

    public abstract void addItem(Product product, Integer quantity);

    public abstract Double getTotalAmount();

    public abstract Double getCampaignDiscount();

    public abstract Double getCouponDiscount();

    public abstract Double getTotalAmountAfterDiscounts();

    public abstract List<CartItem> getItems();

    public abstract ShoppingCartResponse getDetails();

    public abstract void applyCampaign(Campaign campaign);

    public abstract void applyCoupon(Coupon coupon);

    public abstract List<Campaign> getAppliedCampaigns();
}
