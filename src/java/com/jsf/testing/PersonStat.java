/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.testing;

/**
 *
 * @author Lokesh Kotha
 */
public class PersonStat {

    private String name;
    private String gender;
    private String status;

    public PersonStat() {
    }

    public PersonStat(String name, String gender, String status) {
        this.name = name;
        this.gender = gender;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
