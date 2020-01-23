package com.fatihctn.tutorial.util.shopping;

import com.fatihctn.tutorial.config.DeliveryConfig;
import com.fatihctn.tutorial.service.ShoppingCart;
import com.fatihctn.tutorial.util.Calculator;

public class DeliveryCostCalculator implements Calculator<ShoppingCart, Double> {

    private Double costPerDelivery;
    private Double costPerProduct;
    private Double fixedCost;

    public DeliveryCostCalculator(Double costPerDelivery, Double costPerProduct, Double fixedCost) {
        this.costPerDelivery = costPerDelivery;
        this.costPerProduct = costPerProduct;
        this.fixedCost = fixedCost;
    }

    @Override
    public Double calculateFor(ShoppingCart item) {
        return (costPerDelivery * item.getNumberOfCategories())
                + (costPerProduct * item.getNumberOfProducts())
                + fixedCost;
    }
}
