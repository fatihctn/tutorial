package com.fatihctn.tutorial.service;

import com.fatihctn.tutorial.domain.entity.Category;
import com.fatihctn.tutorial.domain.request.CategoryRequest;
import com.fatihctn.tutorial.exception.category.CategoryNotFoundException;
import com.fatihctn.tutorial.mapper.CategoryMapper;
import com.fatihctn.tutorial.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements RepositoryService<Category, Integer> {
    private final static Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    private CategoryRepository repository;

    @Autowired
    private CategoryMapper mapper;

    @Override
    public Category findById(Integer id) throws Exception {
        Optional<Category> category = repository.findById(id);
        if (!category.isPresent()) {
            throw new CategoryNotFoundException(id);
        }
        return category.get();
    }

    public Category save(CategoryRequest request) {
        Category category = mapper.toCategoryFromCategoryRequest(request);
        return repository.save(category);
    }
}
