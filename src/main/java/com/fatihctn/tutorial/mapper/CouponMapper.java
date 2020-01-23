package com.fatihctn.tutorial.mapper;

import com.fatihctn.tutorial.domain.entity.Coupon;
import com.fatihctn.tutorial.domain.request.CouponRequest;
import com.fatihctn.tutorial.domain.response.CouponResponse;
import com.fatihctn.tutorial.mapper.util.DiscountTypeMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CouponMapper extends DiscountTypeMapper {

    Coupon toCouponFromCouponRequest(CouponRequest request);

    @Mapping(target = "discountType", source = "entity.discountValue", qualifiedByName = "discountToString")
    CouponResponse toCouponResponseFromCoupon(Coupon entity);
}
