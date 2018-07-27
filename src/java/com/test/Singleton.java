/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

/**
 *
 * @author lokesh
 */
public enum Singleton {
    Active("Active"),
    Inactive("Inactive"),
    NonClient("Non-Client"),
    Prospect("Prospect");

    private final String name;

    private Singleton(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
