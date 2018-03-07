/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongo.testing;

import com.mongo.location.SpringMongoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 *
 * @author itdev8
 */
public class MasterDAO {

    @Autowired
    private MongoOperations mongoOperations;
    ApplicationContext ac;

    public MasterDAO() {
        ac = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        mongoOperations = (MongoOperations) ac.getBean("mongoTemplate");
    }

    public void saveCity() {
    }

    public void saveState() {
        State s = new State();
        s.setStatename("Andhra Pradesh");
        mongoOperations.save(s);
    }

}
