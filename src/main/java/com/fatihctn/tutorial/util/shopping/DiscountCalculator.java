package com.fatihctn.tutorial.util.shopping;

import com.fatihctn.tutorial.domain.constants.DiscountType;
import com.fatihctn.tutorial.util.Calculator;

import java.text.DecimalFormat;

public class DiscountCalculator implements Calculator<DiscountType, Double> {

    private Double price;
    private Double value;

    public DiscountCalculator(Double price, Double value) {
        this.price = price;
        this.value = value;
    }

    public static Double roundedFractionTwo(Double d) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        return Double.valueOf(df.format(d));
    }

    @Override
    public Double calculateFor(DiscountType item) {
        double calculatedPrice = 0.00D;
        if (DiscountType.AMOUNT.equals(item)) {
            calculatedPrice = price - value;
        } else if (DiscountType.RATE.equals(item)) {
            calculatedPrice = price - (price * value);
        }
        return DiscountCalculator.roundedFractionTwo(calculatedPrice);
    }
}
