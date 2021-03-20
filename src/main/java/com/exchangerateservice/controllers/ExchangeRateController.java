package com.exchangerateservice.controllers;

import com.exchangerateservice.requestTemplate.ExchangeRateRequest;
import com.exchangerateservice.responseTemplate.DefaultResponse;
import com.exchangerateservice.services.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/exchange-api")
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;
    @Autowired
    private ExchangeRateRequest exchangeRateRequest;

    @GetMapping("/exchange-rate/{fromCurrency}/to/{toCurrency}")
    public ResponseEntity<DefaultResponse> getExchangeRates(
            @PathVariable String fromCurrency,
            @PathVariable String toCurrency
    ){

        exchangeRateRequest.setFromCurrency(fromCurrency);
        exchangeRateRequest.setToCurrency(toCurrency);

        return ResponseEntity.ok(exchangeRateService.getExchangeRates(exchangeRateRequest));
    }

    @GetMapping("/currency-convertor/{fromCurrency}/to/{toCurrency}")
    public ResponseEntity<DefaultResponse> convertCurrencies(
            @PathVariable String fromCurrency,
            @PathVariable String toCurrency,
            @RequestParam BigDecimal amount
    ){

        exchangeRateRequest.setFromCurrency(fromCurrency);
        exchangeRateRequest.setToCurrency(toCurrency);
        exchangeRateRequest.setAmount(amount);

        return ResponseEntity.ok(exchangeRateService.convertCurrencies(exchangeRateRequest));
    }

    @GetMapping("/interactive-chart-link/{fromCurrency}/to/{toCurrency}")
    public ResponseEntity<DefaultResponse> getInteractiveChartLink(
            @PathVariable String fromCurrency,
            @PathVariable String toCurrency
    ){

        exchangeRateRequest.setFromCurrency(fromCurrency);
        exchangeRateRequest.setToCurrency(toCurrency);

        return ResponseEntity.ok(exchangeRateService.getInteractiveChartLink(exchangeRateRequest));
    }
}
