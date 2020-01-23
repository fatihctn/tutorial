package com.fatihctn.tutorial.repository;

import com.fatihctn.tutorial.domain.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
}
