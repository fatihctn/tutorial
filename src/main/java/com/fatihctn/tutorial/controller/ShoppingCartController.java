package com.fatihctn.tutorial.controller;

import com.fatihctn.tutorial.domain.request.CartItemRequest;
import com.fatihctn.tutorial.domain.response.ShoppingCartResponse;
import com.fatihctn.tutorial.service.CampaignService;
import com.fatihctn.tutorial.service.ProductService;
import com.fatihctn.tutorial.service.ShoppingCart;
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
@RequestMapping(value = "/shopping-cart")
public class ShoppingCartController {
    private final static Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);

    @Autowired
    private ShoppingCart shoppingCart;

    @Autowired
    private CampaignService campaignService;

    @Autowired
    private ProductService productService;

    @Autowired
    private RequestUtil requestUtil;

    @RequestMapping(method = RequestMethod.POST, value = "/add-item")
    public void addItem(@RequestBody CartItemRequest cartItemRequest) throws Exception {
        logger.info("Adding product to shopping cart. quantity: {}, productId: {}, clientIp: {}",
                cartItemRequest.getQuantity(), cartItemRequest.getProductId(), requestUtil.getClientIp());

        shoppingCart.addItem(
                productService.findById(cartItemRequest.getProductId()),
                cartItemRequest.getQuantity());
    }

    @RequestMapping(method = RequestMethod.GET)
    public ShoppingCartResponse print() {
        logger.info("User listed shopping cart. clientIp: {}", requestUtil.getClientIp());
        return shoppingCart.getDetails();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/apply-campaign/{id}")
    public void applyCampaign(@PathVariable("id") Integer id) {

    }
}
