package com.fatihctn.tutorial.domain.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Builder
public class ShoppingCartResponse {
    private List<CartItemResponse> items;
    private Double totalPrice;
    private Double deliveryCost;
}
