package com.moncker.pricesjavatest.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.moncker.pricesjavatest.response.PriceResponse;
import com.moncker.pricesjavatest.service.impl.PriceServiceImpl;
@WebMvcTest(PriceController.class)
public class PriceControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PriceServiceImpl service;
	
    @Test
    public void whenGetPrices_thenReturnOk() throws Exception {
	    	when(service.getApplicablePrice(any())).thenReturn(PriceResponse.builder().brandId(1).price(15.5).build());
	    	
	    	this.mockMvc.perform(get("/prices?productId=35455&brandId=1&date=2020-06-14 10:00:00")).andDo(print()).andExpect(status().isOk());
    }

}
