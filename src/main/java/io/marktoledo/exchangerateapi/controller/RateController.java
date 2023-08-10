package io.marktoledo.exchangerateapi.controller;


import io.marktoledo.exchangerateapi.dto.Rate;
import io.marktoledo.exchangerateapi.thirdparty.ExchangeRateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/rates")
public class RateController {

    private ExchangeRateProxy exchangeRateProxy;

    @Value("${third-party.exchange-rates-api.api-key}")
    private String apiKey;

    @Autowired
    public RateController(ExchangeRateProxy exchangeRateProxy){
        this.exchangeRateProxy = exchangeRateProxy;
    }

    @GetMapping("")
    public Rate getRate(@RequestParam("base") String base, @RequestParam("symbols") String[] symbols){
        return this.exchangeRateProxy.getRate(this.apiKey,base, String.join(",", symbols));
    }
}

