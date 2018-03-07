/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mongo.testing;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author itdev8
 */
public interface CityRepository extends MongoRepository<City,String>{
    
}
