package com.fatihctn.tutorial.domain.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class CartItemResponse {
    private String categoryName;
    private String productName;
    private Integer quantity;
    private Double unitPrice;
    private Double totalPrice;
    private Double totalDiscount;
    private Double totalLastPrice;
}
