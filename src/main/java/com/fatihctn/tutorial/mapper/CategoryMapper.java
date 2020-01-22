package com.fatihctn.tutorial.mapper;

import com.fatihctn.tutorial.domain.entity.Category;
import com.fatihctn.tutorial.domain.request.CategoryRequest;
import com.fatihctn.tutorial.domain.response.CategoryResponse;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {

    Category toCategoryFromCategoryRequest(CategoryRequest request);

    CategoryResponse toCategoryResponseFromCategory(Category category);
}
