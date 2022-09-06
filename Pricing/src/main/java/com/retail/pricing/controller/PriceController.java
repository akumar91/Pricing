package com.retail.pricing.controller;

import com.retail.pricing.model.Price;
import com.retail.pricing.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prices")
public class PriceController {

    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Price> updatePrice(@RequestBody Price price) {
        return new ResponseEntity<>(new Price(), HttpStatus.CREATED);
    }
}
