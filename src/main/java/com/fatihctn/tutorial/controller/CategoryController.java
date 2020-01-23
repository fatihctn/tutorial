package com.fatihctn.tutorial.controller;

import com.fatihctn.tutorial.domain.request.CategoryRequest;
import com.fatihctn.tutorial.domain.response.CategoryResponse;
import com.fatihctn.tutorial.mapper.CategoryMapper;
import com.fatihctn.tutorial.service.CategoryService;
import com.fatihctn.tutorial.util.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
    private final static Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private RequestUtil requestUtil;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public CategoryResponse getId(@PathVariable("id") Integer id) throws Exception {
        logger.debug("Category getting by Id: {}", id);
        return categoryMapper.toCategoryResponseFromCategory(categoryService.findById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public CategoryResponse saveRequest(@RequestBody CategoryRequest request) {
        logger.debug("Category creating by user ip: {}", requestUtil.getClientIp());
        return categoryMapper.toCategoryResponseFromCategory(categoryService.save(request));
    }

}
