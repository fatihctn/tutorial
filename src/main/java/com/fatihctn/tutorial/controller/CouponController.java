package com.fatihctn.tutorial.controller;

import com.fatihctn.tutorial.domain.request.CouponRequest;
import com.fatihctn.tutorial.domain.response.CouponResponse;
import com.fatihctn.tutorial.mapper.CouponMapper;
import com.fatihctn.tutorial.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/coupons")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @Autowired
    private CouponMapper couponMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public CouponResponse getById(@PathVariable("id") Integer id) throws Exception {
        return couponMapper.toCouponResponseFromCoupon(couponService.findById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public CouponResponse saveRequest(@RequestBody CouponRequest couponRequest) {
        return couponMapper.toCouponResponseFromCoupon(couponService.save(couponRequest));
    }
}
