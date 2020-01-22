package com.fatihctn.tutorial.exception.product;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Product Not Found")
public class ProductNotFoundException extends Exception {
    private static final long serialVersionUID = -7521709338282062047L;

    public ProductNotFoundException(Long entityId) {
        super("Product not found with id=" + entityId);
    }
}
