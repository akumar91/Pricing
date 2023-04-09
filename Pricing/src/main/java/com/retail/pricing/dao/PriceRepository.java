package com.retail.pricing.dao;

import com.retail.pricing.model.Price;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends MongoRepository<Price, Integer> {

    List<Price> findPriceByCategory(String category);

    List<Price> deletePriceByTcin(Integer tcin);

    @Query(value = "{ 'detail.item' : ?0 }")
    List<Price> findPriceByItem(String item);

    @Query(value = "{ 'category' : ?0, 'detail.item' : ?1 }")
    List<Price> findPriceByCategoryAndItem(String category, String item);

}
