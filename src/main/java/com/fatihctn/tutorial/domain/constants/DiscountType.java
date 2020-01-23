package com.fatihctn.tutorial.domain.constants;

public enum DiscountType {
    RATE("RATE"),
    AMOUNT("AMOUNT");

    String type;

    DiscountType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
