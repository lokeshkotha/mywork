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
public class City implements Serializable {

    private String _id;
    private String cityName;
    private Regions regions;

    public City() {
    }

    public City(String _id, String cityName, Regions regions) {
        this._id = _id;
        this.cityName = cityName;
        this.regions = regions;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Regions getRegions() {
        return regions;
    }

    public void setRegions(Regions regions) {
        this.regions = regions;
    }

}
