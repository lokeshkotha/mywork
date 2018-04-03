/*
 * Iman Tech Solutions,
 * Hyderabad, India
 * 
 */
package com.abstracttest;

/**
 *
 * @author Lokesh Kotha
 */
public class Cc1 extends Ab1 {

    public static void main(String[] args) {
        Cc1 cc1 = new Cc1();
        cc1.displayName();
    }
//    
//    public String displayName() {
//        System.out.println("Method from Cc1 called");
//        return "test";
//    }

    @Override
    public String getAllNames() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
