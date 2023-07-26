package com.moncker.pricesjavatest.controller;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moncker.pricesjavatest.request.PriceRequest;
import com.moncker.pricesjavatest.response.PriceResponse;
import com.moncker.pricesjavatest.service.PriceService;

@RestController
@RequestMapping(value = "/prices")
public class PriceController {
	
	@Autowired
	PriceService priceService;
	
	@GetMapping
	public ResponseEntity<PriceResponse> getApplicablePrice(@RequestParam String productId,
			@RequestParam int brandId, @RequestParam @DateTimeFormat(pattern= "yyyy-MM-dd HH:mm:ss") LocalDateTime date) throws NotFoundException {
		
		PriceResponse priceResponse = priceService.getApplicablePrice(
				PriceRequest.builder().productId(productId).brandId(brandId).date(date).build());
	
			
		
		return new ResponseEntity<> (priceResponse, HttpStatus.OK);
		
	}
	

}
