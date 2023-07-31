package com.moncker.pricesjavatest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.moncker.pricesjavatest.model.Brand;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Integer>{

}
