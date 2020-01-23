package com.fatihctn.tutorial.controller;

import com.fatihctn.tutorial.domain.request.CampaignRequest;
import com.fatihctn.tutorial.domain.response.CampaignResponse;
import com.fatihctn.tutorial.mapper.CampaignMapper;
import com.fatihctn.tutorial.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/campaigns")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @Autowired
    private CampaignMapper campaignMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public CampaignResponse getById(@PathVariable("id") Integer id) throws Exception {
        return campaignMapper.toCampaignResponseFromCampaign(campaignService.findById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public CampaignResponse saveRequest(@RequestBody CampaignRequest campaignRequest) {
        return campaignMapper.toCampaignResponseFromCampaign(campaignService.save(campaignRequest));
    }
}
