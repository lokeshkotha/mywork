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
public class StaticSingleton {

    private static final StaticSingleton STATIC_SINGLETON = new StaticSingleton();

    private StaticSingleton() {
        System.out.println("Object created for singleton");
    }

    public static StaticSingleton getInstance() {
        return STATIC_SINGLETON;
    }

    public void show() {
        System.out.println("Singleon using static initialization in Java");
    }
}
