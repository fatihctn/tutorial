package com.fatihctn.tutorial.domain.entity;

import com.fatihctn.tutorial.domain.constants.DiscountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "campaign")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "discount_value", precision = 15, scale = 2)
    private Double discountValue;

    @Enumerated(EnumType.STRING)
    @Column(name = "discount_type")
    private DiscountType discountType;

    @Column(name = "min_items")
    private Integer minItems;

    public Campaign(Category category, Double discountValue, Integer minItems, DiscountType discountType) {
        this.category = category;
        this.discountValue = discountValue;
        this.minItems = minItems;
        this.discountType = discountType;
    }

}
