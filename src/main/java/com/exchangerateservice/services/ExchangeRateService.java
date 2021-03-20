package com.exchangerateservice.services;

import com.exchangerateservice.constants.EuroExchangeRates;
import com.exchangerateservice.constants.ResponseConstants;
import com.exchangerateservice.requestTemplate.ExchangeRateRequest;
import com.exchangerateservice.responseTemplate.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;

@Service
public class ExchangeRateService {

    public DefaultResponse getExchangeRates(ExchangeRateRequest exchangeRateRequest){
        DefaultResponse response;
        if(isValidRequest(exchangeRateRequest)){
            response = new SuccessResponse(getExchangeRate(exchangeRateRequest));
            CurrencyAnalyticsService.updateCurrencyAccessRate(Arrays.asList(exchangeRateRequest.getFromCurrency(),exchangeRateRequest.getToCurrency()));
        }else {
            response = new FailureResponse(ResponseConstants.INVALID_EXCHANGE_PARAMS);
        }
        return response;
    }

    public DefaultResponse convertCurrencies(ExchangeRateRequest exchangeRateRequest){
        DefaultResponse response;
        if(isValidRequest(exchangeRateRequest)){
            BigDecimal exchangeRate = calculateExchangeRate(exchangeRateRequest);
            BigDecimal convertedAmount = exchangeRate.multiply(exchangeRateRequest.getAmount());
            response = new SuccessResponse(new ConvertCurrencyResponse(convertedAmount));
            CurrencyAnalyticsService.updateCurrencyAccessRate(Arrays.asList(exchangeRateRequest.getFromCurrency(),exchangeRateRequest.getToCurrency()));
        }else {
            response = new FailureResponse(ResponseConstants.INVALID_EXCHANGE_PARAMS);
        }
        return response;
    }

    public DefaultResponse getInteractiveChartLink(ExchangeRateRequest exchangeRateRequest){
        DefaultResponse response;
        if(isValidRequest(exchangeRateRequest)){
            String link = EuroExchangeRates.INTERACTIVE_LINK.replaceAll("toCurrency",exchangeRateRequest.getToCurrency()).replaceAll("fromCurrency",exchangeRateRequest.getFromCurrency());
            response = new SuccessResponse(new HashMap<String,String>(){{put("InteractiveLink",link);}});
        }else {
            response = new FailureResponse(ResponseConstants.INVALID_EXCHANGE_PARAMS);
        }
        return response;
    }


    private boolean isValidRequest(ExchangeRateRequest exchangeRateRequest){
        return EuroExchangeRates.EURO_EXCHANGE_RATES.containsKey(exchangeRateRequest.getFromCurrency()) &&
                EuroExchangeRates.EURO_EXCHANGE_RATES.containsKey(exchangeRateRequest.getToCurrency());
    }

    private ExchangeRateResponse getExchangeRate(ExchangeRateRequest exchangeRateRequest){
        BigDecimal exchangeRate = calculateExchangeRate(exchangeRateRequest);
        return new ExchangeRateResponse(exchangeRate, exchangeRateRequest.getToCurrency(), exchangeRateRequest.getFromCurrency());
    }

    private BigDecimal calculateExchangeRate(ExchangeRateRequest exchangeRateRequest) {
        BigDecimal fromCurrencyExchangeRate = EuroExchangeRates.EURO_EXCHANGE_RATES.get(exchangeRateRequest.getFromCurrency());
        BigDecimal toCurrencyExchangeRate = EuroExchangeRates.EURO_EXCHANGE_RATES.get(exchangeRateRequest.getToCurrency());
        return toCurrencyExchangeRate.divide(fromCurrencyExchangeRate, EuroExchangeRates.PRECISION_SCALE, RoundingMode.CEILING);
    }


}
