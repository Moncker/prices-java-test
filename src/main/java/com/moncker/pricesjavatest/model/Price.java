package com.moncker.pricesjavatest.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Table(name = "Prices")
@Builder
public class Price {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "price_id")
	int priceId;
	
	@Column(name = "brand_id")
	int brandId;
	
	@Column(name = "start_date")
	LocalDateTime startDate;
	
	@Column(name = "end_date")
	LocalDateTime endDate;
	
	@Column(name = "price_list")
	int priceList;
	
	@Column(name = "product_id")
	String productId;
	
	@Column(name = "priority")
	int priority;
	
	@Column(name = "price")
	double price;
	
	@Column(name = "curr")
	String currency;
	
	
}
