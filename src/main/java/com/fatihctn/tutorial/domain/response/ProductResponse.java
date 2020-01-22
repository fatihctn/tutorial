package com.fatihctn.tutorial.domain.response;

import com.fatihctn.tutorial.domain.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ProductResponse {

    private long id;

    private String title;

    private Double price;

    private Category category;
}
