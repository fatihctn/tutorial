package com.fatihctn.tutorial.domain.request;

import com.fatihctn.tutorial.domain.constants.DiscountType;
import com.fatihctn.tutorial.domain.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class CampaignRequest {
    private Category category;

    @DecimalMin(value = "0.00")
    private Double discountValue;

    @Min(value = 1)
    private Integer minItems;

    private DiscountType discountType;
}
