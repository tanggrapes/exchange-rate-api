package io.marktoledo.exchangerateapi.thirdparty;

import io.marktoledo.exchangerateapi.dto.Currency;
import io.marktoledo.exchangerateapi.dto.Rate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="exchange-rate", url ="http://api.exchangeratesapi.io/v1")
public interface ExchangeRateProxy {

    @GetMapping("/symbols?access_key={apiKey}")
    Currency getCurrencies(@PathVariable String apiKey);

    @GetMapping("/latest?access_key={apiKey}&base={base}&symbols={symbols}")
    Rate getRate(@PathVariable String apiKey, @PathVariable String base, @PathVariable String symbols);
}
