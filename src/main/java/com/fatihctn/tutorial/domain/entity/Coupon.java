package com.fatihctn.tutorial.domain.entity;

import com.fatihctn.tutorial.domain.constants.DiscountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coupon")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "code")
    private String code;

    @Column(name = "min_cart_amount", precision = 15, scale = 2)
    private Double minCartAmount;

    @Column(name = "discount_value", precision = 15, scale = 2)
    private Double discountValue;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "discount_type")
    private DiscountType discountType;
}
