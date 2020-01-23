package com.fatihctn.tutorial.mapper;

import com.fatihctn.tutorial.domain.constants.DiscountType;
import com.fatihctn.tutorial.domain.entity.Campaign;
import com.fatihctn.tutorial.domain.request.CampaignRequest;
import com.fatihctn.tutorial.domain.response.CampaignResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper
public interface CampaignMapper {

    Campaign toCampaignFromCampaignRequest(CampaignRequest request);

    @Mapping(target = "discountType", source = "entity.discountValue", qualifiedByName = "discountToString")
    CampaignResponse toCampaignResponseFromCampaign(Campaign entity);

    @Named("discountToString")
    public static String discountToString(DiscountType discountType) {
        return discountType.getType();

    }
}
