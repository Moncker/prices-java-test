package com.moncker.pricesjavatest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.moncker.pricesjavatest.model.Price;
import com.moncker.pricesjavatest.repository.PriceRepository;
import com.moncker.pricesjavatest.request.PriceRequest;
import com.moncker.pricesjavatest.response.PriceResponse;
import com.moncker.pricesjavatest.service.impl.PriceServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PriceServiceTest {

		
		@Mock
	    private PriceRepository priceRepository;

	    @InjectMocks
	    private PriceServiceImpl employeeService;

	    private List<Price> prices;


	    @Test
	    public void whenGetApplicablePriceWithAnElement_thenReturnPriceResponse() throws NotFoundException{
	    	
	    	PriceRequest priceRequest = PriceRequest.builder().productId("35500").brandId(1)
	    			.date(LocalDateTime.of(2020, Month.JUNE, 3,22, 20, 30)).build();
	    	
	    	List<Price> prices = new ArrayList<>();
	    	
	    	prices.add(Price.builder().productId("35500").brandId(1).priceList(4).priority(0)
	    			.startDate(LocalDateTime.of(2020, Month.JUNE, 1,22, 20, 30))
	    			.endDate(LocalDateTime.of(2020, Month.JUNE, 20,22, 20, 30))
	    			.price(35.5).build());
	    	
	    	when(priceRepository.findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfter(any(), anyInt(), any(), any()))
    		.thenReturn(prices);
	    	
	    	PriceResponse priceResponse = employeeService.getApplicablePrice(priceRequest);
	    	assertEquals("35500", priceResponse.getProductId());
	    }
	    
	    @Test
	    public void whenGetApplicablePriceWithMoreThanAnElement_thenReturnMorePrioriry() throws NotFoundException{
	    	
	    	PriceRequest priceRequest = PriceRequest.builder().productId("35500").brandId(1)
	    			.date(LocalDateTime.of(2020, Month.JUNE, 3,22, 20, 30)).build();
	    	
	    	List<Price> prices = new ArrayList<>();
	    	
	    	prices.add(Price.builder().productId("35500").brandId(1).priceList(4).priority(0)
	    			.startDate(LocalDateTime.of(2020, Month.JUNE, 1,22, 20, 30))
	    			.endDate(LocalDateTime.of(2020, Month.JUNE, 20,22, 20, 30))
	    			.price(35.5).build());
	    	
	    	prices.add(Price.builder().productId("35500").brandId(1).priceList(4).priority(5)
	    			.startDate(LocalDateTime.of(2020, Month.JUNE, 1,22, 20, 30))
	    			.endDate(LocalDateTime.of(2020, Month.JUNE, 20,22, 20, 30))
	    			.price(28.2).build());
	    	
	    	when(priceRepository.findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfter(any(), anyInt(), any(), any()))
    		.thenReturn(prices);
	    	
	    	PriceResponse priceResponse = employeeService.getApplicablePrice(priceRequest);
	    	assertEquals(28.2, priceResponse.getPrice());
	    }
	    
	    @Test
	    public void whenRepositoryReturnsNull_thenThrowsException() throws NotFoundException {
	    	PriceRequest priceRequest = PriceRequest.builder().productId("35500").brandId(1)
	    			.date(LocalDateTime.of(2020, Month.JUNE, 3,22, 20, 30)).build();
	    	
	    	when(priceRepository.findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfter(any(), anyInt(), any(), any()))
	    		.thenReturn(new ArrayList());
	 
	    	Assertions.assertThrows(NotFoundException.class, () -> employeeService.getApplicablePrice(priceRequest));	    	
	    }
	
}
