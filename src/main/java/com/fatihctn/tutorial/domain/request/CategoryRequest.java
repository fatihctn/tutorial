package com.fatihctn.tutorial.domain.request;

import com.fatihctn.tutorial.domain.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CategoryRequest {
    @Size(min = 2, max = 255)
    private String title;

    private Category parentCategory;
}
