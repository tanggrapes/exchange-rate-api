package io.marktoledo.exchangerateapi;


import io.marktoledo.exchangerateapi.controller.CurrencyController;
import io.marktoledo.exchangerateapi.thirdparty.ExchangeRateProxy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(controllers = CurrencyController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class CurrencyControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExchangeRateProxy exchangeRateProxy;

    @Test
    void testGetCurrencies() throws Exception {

        ResultActions response = mockMvc.perform(get("/api/v1/currencies")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void testGetCurrenciesNotFound() throws Exception {

        ResultActions response = mockMvc.perform(get("/api/v1/currenciesssss")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isNotFound());

    }
}