package com.fatihctn.tutorial.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class CartItem implements Serializable {
    private final static long serialVersionUID = -2157812415974187496L;

    private Product product;
    private Integer qty;
    private Double totalAmount;
    private Double totalAmountWithCampaign;
    private Double totalAmountWithCoupon;

    public Double getTotalAmount() {
        return totalAmount;
    }

    public Double getTotalAmountWithCampaign() {
        BigDecimal convertDecimal = new BigDecimal(totalAmountWithCampaign);
        if (convertDecimal.equals(new BigDecimal("0.00"))) {
            return getTotalAmount();
        }
        return totalAmountWithCampaign;
    }

    public Double getTotalAmountWithCoupon() {
        BigDecimal convertDecimal = new BigDecimal(totalAmountWithCoupon);
        if (convertDecimal.equals(new BigDecimal("0.00"))) {
            return getTotalAmountWithCampaign();
        }
        return totalAmountWithCoupon;
    }
}
