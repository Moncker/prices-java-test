package com.moncker.pricesjavatest.model;

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
@Table(name = "brands")
public class Brand {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "brand_id")
	int brandId;
	
	@Column(name = "name")
	String name;
}
