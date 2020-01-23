package com.fatihctn.tutorial.exception.campaign;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Campaign not found")
public class CampaignNotFoundException extends Exception {
    public CampaignNotFoundException(Integer id) {
        super("Campaign not found with Id: " + id);
    }
}
