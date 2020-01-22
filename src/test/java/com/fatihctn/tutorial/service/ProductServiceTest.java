package com.fatihctn.tutorial.service;

import com.fatihctn.tutorial.domain.entity.Category;
import com.fatihctn.tutorial.domain.entity.Product;
import com.fatihctn.tutorial.domain.request.ProductRequest;
import com.fatihctn.tutorial.exception.product.ProductNotFoundException;
import com.fatihctn.tutorial.mapper.ProductMapper;
import com.fatihctn.tutorial.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductMapper mapper;

    @Test(expected = Exception.class)
    public void whenFindId_thenNotFoundException() throws Exception {
        Mockito.when(repository.findById(anyLong())).thenReturn(null);
        productService.findById(1L);
    }

    @Test
    public void whenFindId_thenProductFound() throws Exception {
        Optional<Product> product = Optional.of(new Product(1L,"Demo", 1.00, new Category()));
        Mockito.when(repository.findById(anyLong())).thenReturn(product);
        Product actualProduct = productService.findById(1L);

        Assertions.assertThat(actualProduct.getId()).isEqualTo(1L);
    }

    @Test
    public void whenSave_thenProductSaved() {
        Category category = new Category(1, "Deneme", null);
        ProductRequest productRequest = new ProductRequest("Demo", 1.00, category);
        Product requestedProduct = new Product("Demo", 1.00);
        Product expectedProduct = new Product(1L, "Demo", 1.00, category);

        Mockito.when(mapper.toProductFromRequest(productRequest)).thenReturn(requestedProduct);
        Mockito.when(repository.save(requestedProduct)).thenReturn(expectedProduct);
        Product actualProduct = productService.save(productRequest);

        Assertions.assertThat(actualProduct).isEqualTo(expectedProduct);
    }

}
