package com.fatihctn.tutorial.domain.response;

import com.fatihctn.tutorial.domain.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CategoryResponse {
    private Integer id;
    private String title;
    private Category parentCategory;
}
