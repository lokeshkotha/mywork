/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

/**
 *
 * @author itdev4
 */
public class City {

    private String _id;
    private String stateid;
    private String cityname;

    public City() {
    }

    public City(String _id, String stateid, String cityname) {
        this._id = _id;
        this.stateid = stateid;
        this.cityname = cityname;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getStateid() {
        return stateid;
    }

    public void setStateid(String stateid) {
        this.stateid = stateid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

}
