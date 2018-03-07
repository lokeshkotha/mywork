package com.jsf.testing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author itdev8
 */
public abstract class Person {

    private String name;
    private String gender;

    public Person(String nm, String gen) {
        this.name = nm;
        this.gender = gen;
    }

    //abstract method
    public abstract void work();

    @Override
    public String toString() {
        return "Name=" + this.name + "::Gender=" + this.gender;
    }

    public void changeName(String newName) {
        this.name = newName;
    }
}
