package com.moncker.pricesjavatest.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Prices")
public class Price {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "price_id")
	int priceId;
	
	@Column(name = "brand_id")
	int brandId;
	
	@Column(name = "start_date")
	LocalDateTime startDate;
	
	@Column(name = "end_date")
	LocalDateTime endDate;
	
	@Column(name = "price_list")
	LocalDate priceList;
	
	@Column(name = "product_id")
	LocalDate productId;
	
	@Column(name = "priority")
	LocalDate priority;
	
	@Column(name = "price")
	LocalDate price;
	
	@Column(name = "curr")
	LocalDate currency;
	
	
}
