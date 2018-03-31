/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cjava.exception;

/**
 *
 * @author lokesh
 */
public class MultiTry {

    public static void main(String[] args) {
        MultiTry multiTry = new MultiTry();
        System.out.println(multiTry.testReturn());
    }

    public String testReturn() {
        try {
//throw new Exception();
            return "1";
        } catch (Exception e) {
            return "2";
        } finally {
//            return "3";
        }

    }
}
