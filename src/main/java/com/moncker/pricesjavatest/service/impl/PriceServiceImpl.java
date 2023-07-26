package com.moncker.pricesjavatest.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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
	public PriceResponse getApplicablePrice(PriceRequest priceRequest) throws NotFoundException {
		
		List<Price> prices = (List<Price>) priceRepository.findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfter(
				priceRequest.getProductId(), priceRequest.getBrandId(), priceRequest.getDate(), priceRequest.getDate());
		
		if (prices.size() == 0)
			throw new NotFoundException();
		
		Price price;
		if (prices.size() == 1) {
			price = prices.get(0);
		}else {
			price = prices.stream().max(Comparator.comparing(Price::getPriority))
					.orElseThrow(NoSuchElementException::new);
		}
		PriceResponse priceResponse = PriceResponse.builder()
				.productId(price.getProductId())
				.brandId(price.getBrandId())
				.tarifa(price.getPriceList())
				.startDate(price.getStartDate())
				.endDate(price.getEndDate())
				.price(price.getPrice()).build();
		
		return priceResponse;
	}

}
