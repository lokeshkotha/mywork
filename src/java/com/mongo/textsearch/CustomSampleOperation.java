/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongo.textsearch;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperationContext;

/**
 *
 * @author itdev8
 */
public class CustomSampleOperation implements AggregationOperation {

    private int size;

    public CustomSampleOperation(int size) {
        this.size = size;
    }

    @Override
    public DBObject toDBObject(final AggregationOperationContext context) {
        return new BasicDBObject("$sample", new BasicDBObject("size", size));
    }
}
