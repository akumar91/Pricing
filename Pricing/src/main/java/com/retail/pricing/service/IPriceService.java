package com.retail.pricing.service;

import com.retail.pricing.model.Price;

import java.util.List;

public interface IPriceService {

    public List<Price> getAllPrices(String category, String item);

    public void deletePrice(Integer tcin);

    public Price createOrUpdatePrice(Price price);

}
