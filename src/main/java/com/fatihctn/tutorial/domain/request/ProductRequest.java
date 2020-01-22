package com.fatihctn.tutorial.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ProductRequest {

    @Size(min = 3, max = 255)
    private String title;

    @DecimalMin(value = "0.00")
    private Double price;
}
