package com.retail.pricing.changeLog;

import com.retail.pricing.dao.PriceRepository;
import com.retail.pricing.model.Detail;
import com.retail.pricing.model.Price;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@ChangeUnit(id="client-initializer", order = "1", author = "akumar")
public class DatabaseChangeLog {

        @Execution
        public void execution(MongoTemplate mongoTemplate) {

            mongoTemplate.insertAll(generateRandomData());
        }

        public List<Price> generateRandomData() {
            List<Price> randomPriceData = new ArrayList<>();

            Map<String, Detail> categoryWithDetails = new HashMap<>();

            // Furniture
            categoryWithDetails.put("Furniture", new Detail(new Random().nextDouble(), "USD", "couch"));
            categoryWithDetails.put("Furniture", new Detail(new Random().nextDouble(), "USD", "Table"));
            categoryWithDetails.put("Furniture", new Detail(new Random().nextDouble(), "USD", "Mattress"));
            categoryWithDetails.put("Furniture", new Detail(new Random().nextDouble(), "USD", "Chairs"));

            // Produce
            categoryWithDetails.put("Produce", new Detail(new Random().nextDouble(), "USD", "Eggs"));
            categoryWithDetails.put("Produce", new Detail(new Random().nextDouble(), "USD", "Milk"));
            categoryWithDetails.put("Produce", new Detail(new Random().nextDouble(), "USD", "Yogurt"));
            categoryWithDetails.put("Produce", new Detail(new Random().nextDouble(), "USD", "Apple"));

            // Electronics
            categoryWithDetails.put("Electronics", new Detail(new Random().nextDouble(), "USD", "Speakers"));
            categoryWithDetails.put("Electronics", new Detail(new Random().nextDouble(), "USD", "Printer"));
            categoryWithDetails.put("Electronics", new Detail(new Random().nextDouble(), "USD", "LG HD Monitor"));

            for (int i = 0; i < 100; i++) {

                Object[] categories = categoryWithDetails.keySet().toArray();
                Object category = categories[new Random().nextInt(categories.length)];
                System.out.println("************ Random Value ************ \n" + category + " :: " + categoryWithDetails.get(category));

                Price price = new Price(new Random().nextInt(), category.toString(), categoryWithDetails.get(category));

                randomPriceData.add(price);
            }

            return randomPriceData;
        }

        @RollbackExecution
        public void rollbackExecution(MongoTemplate mongoTemplate) {

            mongoTemplate.dropCollection("price");

        }
}
