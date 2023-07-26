package com.moncker.pricesjavatest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moncker.pricesjavatest.model.Price;
import com.moncker.pricesjavatest.repository.PriceRepository;
import com.moncker.pricesjavatest.request.PriceRequest;
import com.moncker.pricesjavatest.response.PriceResponse;
import com.moncker.pricesjavatest.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService{
	
	@Autowired
	PriceRepository priceRepository;

	@Override
	public PriceResponse getApplicablePrice(PriceRequest priceRequest) {
		List<Price> prices = (List<Price>) priceRepository.findAll();
		
		PriceResponse priceResponse = PriceResponse.builder().brandId(prices.get(0).getBrandId()).build(); 
		
		return priceResponse;
	}

}
