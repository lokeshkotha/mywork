/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongo.location;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 *
 * @author Lokesh Kotha
 */
public class LocationTest {

    @Autowired
    private final MongoOperations mongoOperation;
    ApplicationContext ctx;

    public LocationTest() {
        ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
    }

    public static void main(String[] args) {
        LocationTest locationTest = new LocationTest();
//        locationTest.addLocation();
        locationTest.nearMe();
    }

    public void addLocation() {
        LocationPojo locationPojo = new LocationPojo();
        locationPojo.setLocationName("GVK One");
        locationPojo.setGeoJsonPoint(new GeoJsonPoint(17.4180204, 78.4432873));
        mongoOperation.save(locationPojo);
        LocationPojo locationPojo2 = new LocationPojo();
        locationPojo2.setLocationName("Tv9");
        locationPojo2.setGeoJsonPoint(new GeoJsonPoint(17.4247664, 78.4385452));
        mongoOperation.save(locationPojo2);
        LocationPojo locationPojo3 = new LocationPojo();
        locationPojo3.setLocationName("almas");
        locationPojo3.setGeoJsonPoint(new GeoJsonPoint(17.4404787, 78.4377513));
        mongoOperation.save(locationPojo3);
    }

    public void nearMe() {
        //partially working
        Distance distance = new Distance(5/111.12, Metrics.NEUTRAL);
        Point point = new Point(17.3753, 78.4744);
        Circle circle = new Circle(point, distance);
//        Shape shape = new Sphere(point, distance);
        Query query = new Query();
        query.addCriteria(Criteria.where("geoJsonPoint").within(circle));
        query.limit(10);
        List<Restaurants> locationPojos = mongoOperation.find(query, Restaurants.class);
        for (Restaurants locationPojo : locationPojos) {
            System.out.println(locationPojo.getGeoJsonPoint().getX() + "-" + locationPojo.getGeoJsonPoint().getY());
            System.out.println(locationPojo.getRestaurantName());
        }
        //not tested
//        Query q2=new Query();
//        q2.addCriteria(Criteria.where("geoJsonPoint").near(point));
//        mongoOperation.indexOps(LocationPojo.class).ensureIndex(new GeospatialIndex("geoJsonPoint"));
//        NearQuery nearQuery = NearQuery.near(point).spherical(true).maxDistance(0.0001).num(10);
//        GeoResults results = mongoOperation.geoNear(nearQuery, LocationPojo.class);
//        List list = results.getContent();
//        Double radius = 1 / 6374.1;
//        System.out.println(radius);
//        Criteria criteria8 = new Criteria("geoJsonPoint").nearSphere(point).maxDistance(radius);
//        Criteria criteria8 = new Criteria("geoJsonPoint").within(circle);
//        List<LocationPojo> tracks = mongoOperation.find(new Query(criteria8), LocationPojo.class);
//        results.getContent().stream().map(results::getContent).collect(Collectors.toList());
//        NearQuery query3 = NearQuery.near(new Point(17.3969132, 78.447486), Metrics.KILOMETERS)
//                .num(10)
//                .minDistance(1)
//                .maxDistance(1)
//                .spherical(true);
//
//        Aggregation a = newAggregation(geoNear(query3, "distance"));
//
//        AggregationResults<LocationPojo> results = mongoOperation.aggregate(a, "geoJsonPoint", LocationPojo.class);
//
//        List<LocationPojo> measurements = new ArrayList<LocationPojo>(results.getMappedResults());

    }

//    public void nearMe2() {
//        List circle = new ArrayList();
//        circle.add(new double[]{17.3969132, 78.447486}); // Centre of circle
//        circle.add(1); // Radius
//        BasicDBObject query = new BasicDBObject("loc", new BasicDBObject("$within",
//                new BasicDBObject("$center", circle)));
//
//        printOutputs(query);
//    }
//
//    public void printOutputs(BasicDBObject query) {
//        Mongo mongo;
//        mongo = new Mongo(new DBAddress("localhost", "27017", "test"));
//        DBCollection collection;
//        collection =mongo.getCollection("");
//        collection.ensureIndex(new BasicDBObject("loc", "2d"), "geospatialIdx");
//        DBCursor cursor = collection.find(query);
//        List<BasicDBList> outputs = new ArrayList<BasicDBList>();
//        while (cursor.hasNext()) {
//            DBObject result = cursor.next();
//            System.out.println(result.get("name") + "--->" + result.get("loc"));
//            outputs.add((BasicDBList) result.get("loc"));
//        }
//
//        for (int y = 9; y >= 0; y--) {
//            String s = "";
//            for (int x = 0; x < 10; x++) {
//                boolean found = false;
//                for (BasicDBList obj : outputs) {
//                    double xVal = (Double) obj.get(0);
//                    double yVal = (Double) obj.get(1);
//                    if (yVal == y && xVal == x) {
//                        found = true;
//                    }
//                }
//                if (found) {
//                    s = s + " @";
//                } else {
//                    s = s + " +";
//                }
//            }
//            System.out.println(s);
//        }
//    }
}
