package com.fatihctn.tutorial.service;

import com.fatihctn.tutorial.domain.entity.Coupon;
import com.fatihctn.tutorial.domain.request.CouponRequest;
import com.fatihctn.tutorial.exception.coupon.CouponNotFoundException;
import com.fatihctn.tutorial.mapper.CouponMapper;
import com.fatihctn.tutorial.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CouponService implements RepositoryService<Coupon, Integer> {

    @Autowired
    private CouponRepository repository;

    @Autowired
    private CouponMapper mapper;

    @Override
    public Coupon findById(Integer id) throws Exception {
        Optional<Coupon> coupon = repository.findById(id);
        if (!coupon.isPresent()) {
            throw new CouponNotFoundException(id);
        }
        return coupon.get();
    }

    public Coupon save(CouponRequest request) {
        return repository.save(mapper.toCouponFromCouponRequest(request));
    }
}
