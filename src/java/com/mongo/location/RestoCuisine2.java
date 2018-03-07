/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongo.location;

/**
 *
 * @author Lokesh Kotha
 */
public class RestoCuisine2 {

    private String _id;
    private Restaurants restaurants;
    private Cuisines cuisines;
    private Restaurants restaurants2;

    public RestoCuisine2() {
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

    public Restaurants getRestaurants2() {
        return restaurants2;
    }

    public void setRestaurants2(Restaurants restaurants2) {
        this.restaurants2 = restaurants2;
    }

}
