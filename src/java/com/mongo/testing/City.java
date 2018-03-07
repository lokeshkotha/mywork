/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongo.testing;

import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 *
 * @author itdev8
 */
public class City {

    private String _id;
    @DBRef
    private State statename;
    private String cityname;

    public City() {
    }

    public City(String _id, State statename, String cityname) {
        this._id = _id;
        this.statename = statename;
        this.cityname = cityname;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public State getStatename() {
        return statename;
    }

    public void setStatename(State statename) {
        this.statename = statename;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }
    
}
