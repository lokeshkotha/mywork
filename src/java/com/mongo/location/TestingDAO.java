/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongo.location;

import com.mongo.location.SpringMongoConfig;
import com.mongodb.BasicDBObject;
import com.test.City;
import com.test.CityTest;
import com.test.State;
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
import org.springframework.data.mongodb.core.query.Query;

/**
 *
 * @author itdev4
 */
public class TestingDAO {

    @Autowired
    private MongoOperations mongoOperation;
    ApplicationContext ctx;

    public TestingDAO() {
        ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
    }

    public String saveState(State s) {
        mongoOperation.save(s);
        return s.getId();
    }

    public String saveCity(City c) {
        mongoOperation.save(c);
        return c.getId();
    }

    public CityTest getCityById() {
//        Aggregation aggregation = newAggregation(match(Criteria.where("username").is("user001")),new CustomAggregationOperation(new BasicDBObject("$lookup",
//                                new BasicDBObject("from", "NewFeedContent")
//                                .append("localField", "content.contentId")
//                                .append("foreignField", "_id")
//                                .append("as", "NewFeedContent")
//                        )
//                )
//        )

//        Aggregation agg = new Aggregation(
//                project("tags"),
//                unwind("tags"),
//                group("tags").count().as("n"),
//                project("n").and("tag").previousOperation(),
//        );
//        
//        Aggregation agg = newAggregation(
//                        Fields.from(Fields.field("State"),Fields.field("localField","stateid"),Fields.field("foreignField","_id"),Fields.field("as","inventory_docs")),
//			match(Criteria.where("_id").lt(10)),
//			group("hosting").count().as("total"),
//			project("total").and("hosting").previousOperation(),
//			sort(Sort.Direction.DESC, "total")
//
//		);
//        Aggregation aggregation = newAggregation(
//                match(
//                        Criteria.where("_id").is(new ObjectId("58a18eaf63e8f60da4d57b98"))
//                ),
//                new CustomAggregationOperation(
//                        new BasicDBObject(
//                                "$lookup",
//                                new BasicDBObject("from", "state")
//                                .append("localField", "stateid")
//                                .append("foreignField", "_id")
//                                .append("as", "testrecord")
//                        )
//                )
//        );
//        AggregationResults aggregationResults=mongoOperation.aggregate(aggregation, "test", City.class);
//
//        return null;
//        Query q=new Query();
//        q.addCriteria(Criteria.where("_id").is(new ObjectId("58a18eaf63e8f60da4d57b98")));
        MatchOperation matchOperation = new MatchOperation(Criteria.where("_id").is(new ObjectId("58a18eaf63e8f60da4d57b98")));
        LookupOperation lookupOperation = LookupOperation.newLookup().
                from("state").
                localField("stateid").
                foreignField("_id").
                as("inventory_docs");
        Aggregation aggregation = Aggregation.newAggregation(matchOperation, lookupOperation);
        List<BasicDBObject> results = mongoOperation.aggregate(aggregation, "city", BasicDBObject.class).getMappedResults();
        return null;
    }

}
