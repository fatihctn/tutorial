package com.fatihctn.tutorial.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class CartItem implements Serializable {
    private final static long serialVersionUID = -2157812415974187496L;

    private Product product;
    private Integer qty;
    private Double totalAmount;

}
