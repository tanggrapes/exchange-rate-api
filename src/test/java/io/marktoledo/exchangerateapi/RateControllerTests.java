package io.marktoledo.exchangerateapi;


import io.marktoledo.exchangerateapi.controller.RateController;
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

@WebMvcTest(controllers = RateController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class RateControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExchangeRateProxy exchangeRateProxy;

    @Test
    void testGetRateValidParam() throws Exception {

        ResultActions response = mockMvc.perform(get("/api/v1/rates")
                .contentType(MediaType.APPLICATION_JSON)
                .param("base", "EUR")
                .param("symbols", "USD,PHP"));

        response.andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void testGetRateNoParam() throws Exception {

        ResultActions response = mockMvc.perform(get("/api/v1/rates")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isBadRequest());

    }

    @Test
    void testGetRateNoSymbols() throws Exception {

        ResultActions response = mockMvc.perform(get("/api/v1/rates")
                .contentType(MediaType.APPLICATION_JSON)
                .param("base", "EUR"));

        response.andExpect(MockMvcResultMatchers.status().isBadRequest());

    }


    @Test
    void testGetRateNotFoundWrongUrl() throws Exception {

        ResultActions response = mockMvc.perform(get("/api/v1/ratess")
                .contentType(MediaType.APPLICATION_JSON)
                .param("base", "EUR"));

        response.andExpect(MockMvcResultMatchers.status().isNotFound());

    }
}
