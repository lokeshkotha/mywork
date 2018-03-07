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
public enum XMLMovingDistance {
    Local("101"),
    Long("102"),
    Auto("103"),
    International("104");

    private final String name;

    private XMLMovingDistance(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
