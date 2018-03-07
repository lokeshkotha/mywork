/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cjava.exception;

/**
 *
 * @author Lokesh Kotha
 */
public class CustomCheckedException {

    public Person findPersonByName(String name) throws NameNotFoundException {
        if ("".equals(name)) {
            throw new NameNotFoundException("Person Name is empty!");
        }
        return new Person("Testing", "");
    }
}
