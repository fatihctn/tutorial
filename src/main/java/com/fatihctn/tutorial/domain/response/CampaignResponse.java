package com.fatihctn.tutorial.domain.response;

import com.fatihctn.tutorial.domain.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CampaignResponse {
    private Integer id;
    private Category category;
    private Double discountValue;
    private Integer minItems;
    private String discountType;
}
