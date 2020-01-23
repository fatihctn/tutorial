package com.fatihctn.tutorial.domain.request;

import com.fatihctn.tutorial.domain.constants.DiscountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CouponRequest {
    @DecimalMin(value = "0.00")
    private Double minCartAmount;

    @DecimalMin(value = "0.00")
    private Double discountValue;

    private DiscountType discountType;
}
