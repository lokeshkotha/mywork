/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongo.location;

import com.mongodb.BasicDBObject;
import com.mongodb.util.JSON;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;

/**
 *
 * @author Lokesh Kotha
 */
public class AggregationTest {

    @Autowired
    private final MongoOperations mongoOperation;
    ApplicationContext ctx;

    public AggregationTest() {
        ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
    }

    public static void main(String[] args) {
        AggregationTest aggregationTest = new AggregationTest();
//        locationTest.addLocation();
        aggregationTest.match();
    }

    public String match() {
        MatchOperation matchOperation = new MatchOperation(Criteria.where("cuisines._id").is(new ObjectId("5a34c35539c7ac9fc859cdd4")));
        LookupOperation lookupOperation = LookupOperation.newLookup().
                from("restaurants").
                localField("restaurants._id").
                foreignField("_id").
                as("restaurants2");
        Aggregation aggregation = Aggregation.newAggregation(matchOperation, lookupOperation);
        List<BasicDBObject> results = mongoOperation.aggregate(aggregation, "restaurantCuisines", BasicDBObject.class).getMappedResults();
        return null;
    }
}
