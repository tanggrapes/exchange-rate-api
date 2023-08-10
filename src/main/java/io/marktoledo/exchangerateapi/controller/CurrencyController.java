package io.marktoledo.exchangerateapi.controller;


import io.marktoledo.exchangerateapi.dto.Currency;
import io.marktoledo.exchangerateapi.thirdparty.ExchangeRateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/currencies")
public class CurrencyController {

    private ExchangeRateProxy exchangeRateProxy;

    @Value("${third-party.exchange-rates-api.api-key}")
    private String apiKey;

    @Autowired
    public CurrencyController(ExchangeRateProxy exchangeRateProxy){
        this.exchangeRateProxy = exchangeRateProxy;
    }

    @GetMapping
    public Currency getCurrencies(){
        return this.exchangeRateProxy.getCurrencies(this.apiKey);
    }

}