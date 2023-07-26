package com.moncker.pricesjavatest.request;

import java.time.LocalDateTime;

import com.moncker.pricesjavatest.response.PriceResponse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceRequest {

	String productId;
	int brandId;
	LocalDateTime date;
}
