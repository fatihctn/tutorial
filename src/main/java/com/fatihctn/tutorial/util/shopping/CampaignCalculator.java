package com.fatihctn.tutorial.util.shopping;

import com.fatihctn.tutorial.domain.entity.Campaign;
import com.fatihctn.tutorial.domain.entity.CartItem;
import com.fatihctn.tutorial.service.ShoppingCart;
import com.fatihctn.tutorial.util.Calculator;
import com.fatihctn.tutorial.util.ShoppingCartProductCalculator;

import java.util.List;

public class CampaignCalculator implements Calculator<ShoppingCart, Double> {

    private Campaign actualCampaign = null;
    private Double totalDiscount = 0.00D;

    @Override
    public Double calculateFor(ShoppingCart item) {
        ShoppingCartProductCalculator shoppingCartProductCalculator = new ShoppingCartProductCalculator(item.getItems());

        Campaign lastCampaign = null;
        double lastCampaignDiscount = 0.00D;
        for (Campaign campaign: item.getAppliedCampaigns()) {
            Integer numberOfProducts = shoppingCartProductCalculator.calculateFor(campaign.getCategory());
            if (numberOfProducts >= campaign.getMinItems()) {
                List<CartItem> cartItems = shoppingCartProductCalculator.listCartItemFor(campaign.getCategory());
                double tempDiscount = cartItems.stream()
                        .mapToDouble(cartItem -> calculateItemFor(cartItem, campaign)
                                ).sum();
                if (tempDiscount >= lastCampaignDiscount) {
                    lastCampaignDiscount = tempDiscount;
                    lastCampaign = campaign;
                }

            }
        }
        totalDiscount = lastCampaignDiscount;
        actualCampaign = lastCampaign;

        return getTotalDiscount();
    }

    public Double calculateItemFor(CartItem cartItem, Campaign campaign) {
        return (new DiscountCalculator(cartItem.getTotalAmount(), campaign.getDiscountValue()))
                .calculateFor(campaign.getDiscountType());
    }

    public Campaign getActualCampaign() {
        return actualCampaign;
    }

    public Double getTotalDiscount() {
        return totalDiscount;
    }
}
