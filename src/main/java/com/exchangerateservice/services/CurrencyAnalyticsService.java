package com.exchangerateservice.services;

import com.exchangerateservice.constants.EuroExchangeRates;
import com.exchangerateservice.responseTemplate.CurrencyAnalyticsResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyAnalyticsService {

    private HashMap<String, Long> currencyAccessRate = new HashMap<>();

    private static CurrencyAnalyticsService currencyAnalyticsService;

    private CurrencyAnalyticsService() {
    }

    public HashMap<String, Long> getCurrencyAccessRate() {
        return currencyAccessRate;
    }

    private void initializeCurrencyAccessRates(){
        EuroExchangeRates.EURO_EXCHANGE_RATES.forEach((key, value) -> currencyAccessRate.putIfAbsent(key, 0L));
    }

    public static CurrencyAnalyticsService getInstance(){
        synchronized(CurrencyAnalyticsService.class) {
            if (currencyAnalyticsService == null) {
                currencyAnalyticsService = new CurrencyAnalyticsService();
                currencyAnalyticsService.initializeCurrencyAccessRates();
            }
        }
        return currencyAnalyticsService;
    }

    public static void updateCurrencyAccessRate(List<String> currencies){
        CurrencyAnalyticsService currencyAnalyticsService = getInstance();
        synchronized(CurrencyAnalyticsService.class) {
            currencies
                    .forEach(
                            currency ->
                                    currencyAnalyticsService.getCurrencyAccessRate().put(
                                            currency,
                                            currencyAnalyticsService.getCurrencyAccessRate().get(currency) + 1
                                    )
                    );
        }
    }

    public static List<CurrencyAnalyticsResponse> getCurrencyAnalytics(){
        return getInstance().getCurrencyAccessRate()
                .entrySet()
                .stream()
                .map(e->new CurrencyAnalyticsResponse(e.getKey(),e.getValue()))
                .collect(Collectors.toList());
    }

}
