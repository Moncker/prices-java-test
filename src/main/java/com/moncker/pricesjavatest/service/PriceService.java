package com.moncker.pricesjavatest.service;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.moncker.pricesjavatest.request.PriceRequest;
import com.moncker.pricesjavatest.response.PriceResponse;

@Service
public interface PriceService {

	public PriceResponse getApplicablePrice(PriceRequest priceRequest) throws NotFoundException;
	
}
