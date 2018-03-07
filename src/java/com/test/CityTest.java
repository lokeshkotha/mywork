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
public class CityTest {

    private String _id;
    private State stateid;
    private String cityname;

    public CityTest() {
    }

    public CityTest(String _id, State stateid, String cityname) {
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

    public State getStateid() {
        return stateid;
    }

    public void setStateid(State stateid) {
        this.stateid = stateid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

}
