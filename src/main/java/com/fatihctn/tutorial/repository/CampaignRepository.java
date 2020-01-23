package com.fatihctn.tutorial.repository;

import com.fatihctn.tutorial.domain.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Integer> {
}
