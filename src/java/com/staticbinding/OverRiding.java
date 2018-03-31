/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.staticbinding;

/**
 *
 * @author lokesh
 */
public class OverRiding {
    public static void main(String[] args) {
        Person1 p1=new Person2();
        p1.name();
    }
}
