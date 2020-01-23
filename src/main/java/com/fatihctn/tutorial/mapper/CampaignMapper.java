package com.fatihctn.tutorial.mapper;

import com.fatihctn.tutorial.domain.constants.DiscountType;
import com.fatihctn.tutorial.domain.entity.Campaign;
import com.fatihctn.tutorial.domain.request.CampaignRequest;
import com.fatihctn.tutorial.domain.response.CampaignResponse;
import com.fatihctn.tutorial.mapper.util.DiscountTypeMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper
public interface CampaignMapper extends DiscountTypeMapper {

    Campaign toCampaignFromCampaignRequest(CampaignRequest request);

    @Mapping(target = "discountType", source = "entity.discountValue", qualifiedByName = "discountToString")
    CampaignResponse toCampaignResponseFromCampaign(Campaign entity);


}
