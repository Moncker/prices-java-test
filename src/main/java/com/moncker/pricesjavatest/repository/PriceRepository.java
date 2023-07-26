package com.moncker.pricesjavatest.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.moncker.pricesjavatest.model.Price;

@Repository
public interface PriceRepository extends CrudRepository<Price, Integer>{

	public List<Price> findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfter(
			String productId, int brandId, LocalDateTime date, LocalDateTime date1 );
}
