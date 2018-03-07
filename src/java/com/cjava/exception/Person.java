package com.cjava.exception;

import com.jsf.testing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author itdev8
 */
public class Person {

    private String name;
    private String gender;

    public Person(String nm, String gen) {
        this.name = nm;
        this.gender = gen;
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

}
