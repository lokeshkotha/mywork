package com.mongo.location;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import java.util.Arrays;
import javax.annotation.PreDestroy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
public class SpringMongoConfig {

    MongoClient mongoClient;
    MongoTemplate mongoTemplate;

    public @Bean
    MongoDbFactory mongoDbFactory() throws Exception {

        MongoClientOptions mongoClientOptions = MongoClientOptions.builder()
                .connectionsPerHost(15)
                .connectTimeout(1000)
                .maxWaitTime(1500)
                .socketKeepAlive(true)
                .socketTimeout(1500)
                .threadsAllowedToBlockForConnectionMultiplier(8)
                .maxConnectionIdleTime(60000).build();
//        MongoCredential credential = MongoCredential.createCredential("indserver", "admin", "Mac@114".toCharArray());
//        ServerAddress serverAddress = new ServerAddress("139.59.5.118", 27017);
//        mongoClient = new MongoClient(serverAddress, Arrays.asList(credential), mongoClientOptions);
//        MongoCredential credential = MongoCredential.createCredential("demoserver", "admin", "Mac@114".toCharArray());
//        ServerAddress serverAddress = new ServerAddress("139.59.94.250", 27017);
//        mongoClient = new MongoClient(serverAddress, Arrays.asList(credential), mongoClientOptions);
        MongoCredential credential = MongoCredential.createCredential("admin", "admin", "admin".toCharArray());
        ServerAddress serverAddress = new ServerAddress("localhost", 27017);
        mongoClient = new MongoClient(serverAddress,Arrays.asList(credential), mongoClientOptions);
        SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "resto");
        return simpleMongoDbFactory;
    }

    public @Bean
    MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        // show error, should off on production to speed up performance
        mongoTemplate.setWriteConcern(WriteConcern.ACKNOWLEDGED);
        return mongoTemplate;
    }

    @PreDestroy
    public void shutdown() {
        mongoClient.close();
    }
}
