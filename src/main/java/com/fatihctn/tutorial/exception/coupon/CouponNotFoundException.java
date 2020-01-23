package com.fatihctn.tutorial.exception.coupon;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Coupon Not Found")
public class CouponNotFoundException extends Exception {
    private final static long serialVersionUID = -3759078179587411606L;

    public CouponNotFoundException(Integer entityId) {
        super("Coupon not found with Id="+ entityId);
    }
}
