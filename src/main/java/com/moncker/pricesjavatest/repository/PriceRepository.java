package com.moncker.pricesjavatest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.moncker.pricesjavatest.model.Price;

@Repository
public interface PriceRepository extends CrudRepository<Price, Integer>{

}
