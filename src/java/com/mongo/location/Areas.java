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
public class Areas implements Serializable {

    private String _id;
    private String areaName;
    private City city;

    public Areas() {
    }

    public Areas(String _id, String areaName, City city) {
        this._id = _id;
        this.areaName = areaName;
        this.city = city;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
