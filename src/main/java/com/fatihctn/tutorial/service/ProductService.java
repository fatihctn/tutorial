package com.fatihctn.tutorial.service;

import com.fatihctn.tutorial.domain.entity.Product;
import com.fatihctn.tutorial.domain.request.ProductRequest;
import com.fatihctn.tutorial.exception.product.ProductNotFoundException;
import com.fatihctn.tutorial.mapper.ProductMapper;
import com.fatihctn.tutorial.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private final static Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductMapper mapper;

    public Product findById(Long id) throws Exception {
        Optional<Product> product = repository.findById(id);
        if (!product.isPresent()) {
            throw new ProductNotFoundException(id);
        }
        return product.get();
    }

    public Product save(ProductRequest productRequest) {
        Product product = mapper.toProductFromRequest(productRequest);
        return repository.save(product);
    }

}
