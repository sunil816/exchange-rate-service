package com.exchangerateservice.controllers;

import com.exchangerateservice.responseTemplate.DefaultResponse;
import com.exchangerateservice.responseTemplate.SuccessResponse;
import com.exchangerateservice.services.CurrencyAnalyticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exchange-api")
public class CurrencyAnalyticsController {

    @GetMapping("/currency-analytics")
    public ResponseEntity<DefaultResponse> getCurrencyAnalytics(){
        return ResponseEntity.ok(new SuccessResponse(CurrencyAnalyticsService.getCurrencyAnalytics()));
    }
}