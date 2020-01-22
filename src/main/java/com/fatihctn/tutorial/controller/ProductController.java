package com.fatihctn.tutorial.controller;

import com.fatihctn.tutorial.domain.request.ProductRequest;
import com.fatihctn.tutorial.domain.response.ProductResponse;
import com.fatihctn.tutorial.mapper.ProductMapper;
import com.fatihctn.tutorial.service.ProductService;
import com.fatihctn.tutorial.util.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    private final static Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private RequestUtil requestUtil;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ProductResponse getId(@RequestPart("id") Long id) throws Exception {
        logger.debug("Product getting by Id: {}", id);
        return productMapper.toProductResponseFromProduct(productService.findById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ProductResponse saveRequest(@RequestBody ProductRequest request) {
        logger.debug("Product creating by user ip: {}", requestUtil.getClientIp());
        return productMapper.toProductResponseFromProduct(productService.save(request));
    }
}
