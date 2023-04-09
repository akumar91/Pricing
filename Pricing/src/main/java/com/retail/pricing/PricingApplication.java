package com.retail.pricing;

import com.retail.pricing.dao.PriceRepository;
import com.retail.pricing.model.Price;
import com.retail.pricing.service.KafkaProducerService;
import io.mongock.runner.springboot.EnableMongock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
@EnableMongock
public class PricingApplication {

	@Autowired
	private KafkaProducerService kafkaProducerService;

	@Autowired
	private PriceRepository priceRepository;

	public static void main(String[] args) {
		SpringApplication.run(PricingApplication.class, args);
	}

	@PostConstruct
	public void publishAll() {
		List<Price> pricesData = priceRepository.findAll();
		System.out.println("Publish Data");
		for(Price priceData : pricesData) {
			kafkaProducerService.send(priceData);
		}
	}

//	@KafkaListener(topics = "techgeeknext-topic", groupId = "techgeeknext-group")
//	public void listen(Price user) {
//
//		System.out.println("Received User information : " + user);
//	}

}
