package com.fatihctn.tutorial.util.shopping;

import com.fatihctn.tutorial.domain.entity.CartItem;
import com.fatihctn.tutorial.domain.entity.Coupon;
import com.fatihctn.tutorial.util.Calculator;

public class CouponCalculator implements Calculator<CartItem, Double> {

    private Coupon coupon;

    public CouponCalculator(Coupon coupon) {
        this.coupon = coupon;
    }

    @Override
    public Double calculateFor(CartItem item) {
        DiscountCalculator discountCalculator = new DiscountCalculator(item.getTotalAmountWithCampaign(), coupon.getDiscountValue());
        return discountCalculator.calculateFor(coupon.getDiscountType());
    }
}
