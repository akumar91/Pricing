package com.retail.pricing.controller;

import com.retail.pricing.model.Price;
import com.retail.pricing.service.IPriceService;
import com.retail.pricing.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prices")
public class PriceController {

    private final IPriceService priceService;

    @Autowired
    public PriceController(IPriceService priceService) {
        this.priceService = priceService;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> createPrice(@RequestBody Price price) {
        priceService.createOrUpdatePrice(price);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Price>> getPrices(@RequestParam(required = false) String category,
                                                 @RequestParam(required = false) String item) {
        List<Price> prices = priceService.getAllPrices(category, item);
        return new ResponseEntity<>(prices, HttpStatus.OK);
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<Price> updatePrice(@RequestBody Price price) {
        Price updatePrice = priceService.createOrUpdatePrice(price);
        return new ResponseEntity<>(updatePrice, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{tcin}")
    public ResponseEntity<Void> createPrice(@PathVariable Integer tcin) {
        priceService.deletePrice(tcin);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
