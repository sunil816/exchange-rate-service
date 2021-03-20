package com.exchangerateservice.responseTemplate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class CurrencyAnalyticsResponse {
    private String currency;

    private Long noOfRequests;

    public CurrencyAnalyticsResponse(String currency, Long noOfRequests) {
        this.currency = currency;
        this.noOfRequests = noOfRequests;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getNoOfRequests() {
        return noOfRequests;
    }

    public void setNoOfRequests(Long noOfRequests) {
        this.noOfRequests = noOfRequests;
    }
}
