package com.fatihctn.tutorial.mapper.util;

import com.fatihctn.tutorial.domain.constants.DiscountType;
import org.mapstruct.Named;

public interface DiscountTypeMapper {

    @Named("discountToString")
    public static String discountToString(DiscountType discountType) {
        return discountType.getType();

    }
}
