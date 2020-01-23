package com.fatihctn.tutorial.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CouponResponse {

    private Integer id;
    private String code;
    private Double minCartAmount;
    private Double discountValue;
    private String discountType;

}
