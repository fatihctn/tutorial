package com.fatihctn.tutorial.mapper;

import com.fatihctn.tutorial.domain.entity.Product;
import com.fatihctn.tutorial.domain.request.ProductRequest;
import com.fatihctn.tutorial.domain.response.ProductResponse;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {

    Product toProductFromRequest(ProductRequest request);

    ProductResponse toProductResponseFromProduct(Product product);
}
