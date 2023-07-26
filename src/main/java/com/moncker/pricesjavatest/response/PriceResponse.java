package com.moncker.pricesjavatest.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceResponse {
	
	String productId;
	int brandId;
	int tarifa;
	
	LocalDateTime startDate;
	LocalDateTime endDate;
	double price;	

}
