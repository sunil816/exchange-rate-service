package com.exchangerateservice.constants;

import java.math.BigDecimal;
import java.util.HashMap;
public class EuroExchangeRates {
    public static final HashMap<String, BigDecimal> EURO_EXCHANGE_RATES = new HashMap<String, BigDecimal>()
    {
        {

            put("EUR", new BigDecimal(1));
            put("USD", new BigDecimal(1.1912));
            put("BGN", new BigDecimal(1.9558));
            put("CZK", new BigDecimal(26.159));
            put("DKK", new BigDecimal(7.436));
            put("GBP", new BigDecimal(0.85668));
            put("HUF", new BigDecimal(367.74));
            put("PLN", new BigDecimal(4.6136));
            put("RON", new BigDecimal(4.8874));
            put("SEK", new BigDecimal(10.1355));
            put("CHF", new BigDecimal(1.1047));
            put("ISK", new BigDecimal(151.4));
            put("NOK", new BigDecimal(10.1213));
            put("HRK", new BigDecimal(7.5765));
            put("RUB", new BigDecimal(87.8245));
            put("TRY", new BigDecimal(8.9498));
            put("AUD", new BigDecimal(1.5427));
            put("BRL", new BigDecimal(6.7299));
            put("CAD", new BigDecimal(1.4852));
            put("CNY", new BigDecimal(7.7435));
            put("HKD", new BigDecimal(9.2476));
            put("IDR", new BigDecimal(17216.3));
            put("ILS", new BigDecimal(3.9155));
            put("INR", new BigDecimal(86.429));
            put("KRW", new BigDecimal(1346.65));
            put("MXN", new BigDecimal(24.6882));
            put("MYR", new BigDecimal(4.9075));
            put("NZD", new BigDecimal(1.6618));
            put("PHP", new BigDecimal(57.982));
            put("SGD", new BigDecimal(1.6036));
            put("THB", new BigDecimal(36.656));
            put("ZAR", new BigDecimal(17.718));
        }
    };

    public static final Integer PRECISION_SCALE = 5;

    public static final String INTERACTIVE_LINK = "https://www.exchangerateservice.com/interactive-chart/toCurrency-to-fromCurrency.html";
}
