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
//f the client is able to recover from the exception, make it a checked exception. To create a custom checked exception, extends java.lang.Exception
public class NameNotFoundException extends Exception {

    public NameNotFoundException(String message) {
        super(message);
    }
}
