package com.fatihctn.tutorial.repository;

import com.fatihctn.tutorial.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
