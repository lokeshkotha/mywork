/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongo.location;

import java.io.Serializable;

/**
 *
 * @author itdev7
 */
public class RestaurantCuisines implements Serializable {

    private String _id;
    private Restaurants restaurants;
    private Cuisines cuisines;

    public RestaurantCuisines() {
    }

    public RestaurantCuisines(String _id, Restaurants restaurants, Cuisines cuisines) {
        this._id = _id;
        this.restaurants = restaurants;
        this.cuisines = cuisines;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public Restaurants getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Restaurants restaurants) {
        this.restaurants = restaurants;
    }

    public Cuisines getCuisines() {
        return cuisines;
    }

    public void setCuisines(Cuisines cuisines) {
        this.cuisines = cuisines;
    }

}
