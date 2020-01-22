package com.fatihctn.tutorial.exception.category;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Category not found")
public class CategoryNotFoundException extends Exception {
    private static final long serialVersionUID = 3601355502813375822L;

    public CategoryNotFoundException(Integer entityId) {
        super("Category not found with id=" + entityId);
    }
}
