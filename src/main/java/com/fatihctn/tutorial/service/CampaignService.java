package com.fatihctn.tutorial.service;

import com.fatihctn.tutorial.domain.entity.Campaign;
import com.fatihctn.tutorial.domain.request.CampaignRequest;
import com.fatihctn.tutorial.exception.campaign.CampaignNotFoundException;
import com.fatihctn.tutorial.mapper.CampaignMapper;
import com.fatihctn.tutorial.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CampaignService implements RepositoryService<Campaign, Integer> {

    @Autowired
    private CampaignRepository repository;

    @Autowired
    private CampaignMapper mapper;

    @Override
    public Campaign findById(Integer id) throws Exception {
        Optional<Campaign> campaign = repository.findById(id);
        if (!campaign.isPresent()) {
            throw new CampaignNotFoundException(id);
        }
        return campaign.get();
    }

    public Campaign save(CampaignRequest request) {
        Campaign campaign = mapper.toCampaignFromCampaignRequest(request);
        return repository.save(campaign);
    }
}
