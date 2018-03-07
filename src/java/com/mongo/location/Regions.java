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
public class Regions implements Serializable {

    private String _id;
    private String regionName;
    private Country country;

    public Regions() {
    }

    public Regions(String _id, String regionName, Country country) {
        this._id = _id;
        this.regionName = regionName;
        this.country = country;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
