/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongo.testing;

/**
 *
 * @author itdev8
 */
public class State {

    private String _id;
    private String statename;

    public State() {
    }

    public State(String _id, String statename) {
        this._id = _id;
        this.statename = statename;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getStatename() {
        return statename;
    }

    public void setStatename(String statename) {
        this.statename = statename;
    }

}
