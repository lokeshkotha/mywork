/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abstracttest;

/**
 *
 * @author lokesh
 */
public interface Intf {

    default String getPropertyName() {
        System.out.println("Default functional interface is working");
        return "default functional interface returning";
    }
}
