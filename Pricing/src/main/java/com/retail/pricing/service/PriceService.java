package com.retail.pricing.service;

import com.retail.pricing.dao.PriceRepository;
<<<<<<< HEAD
import com.retail.pricing.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceService implements IPriceService {
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceService {
>>>>>>> origin/main

    private final PriceRepository priceRepository;

    @Autowired
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }
<<<<<<< HEAD

    @Override
    public List<Price> getAllPrices(String category, String item) {
        List<Price> prices;
        if (category != null && item != null) {
            prices = priceRepository.findPriceByCategoryAndItem(category, item);
        } else if (category != null) {
            prices = priceRepository.findPriceByCategory(category);
        } else if (item != null) {
            prices = priceRepository.findPriceByItem(item);
        } else {
            prices = priceRepository.findAll();
        }

        return prices;
    }

    @Override
    public void deletePrice(Integer tcin) {
        priceRepository.deletePriceByTcin(tcin);
    }

    @Override
    public Price createOrUpdatePrice(Price price) {
        Price savedPrice = priceRepository.save(price);
        return savedPrice;
    }

=======
>>>>>>> origin/main
}
