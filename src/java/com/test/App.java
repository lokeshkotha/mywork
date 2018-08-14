/*
 * Iman Tech Solutions,
 * Hyderabad, India
 * 
 */
package com.test;

import java.util.Date;

/**
 *
 * @author Lokesh Kotha
 */
public class App {
    public static void main(String[] args) {
        ImmutableClass immutableClass=new ImmutableClass(new Date(),"test", "913246579");
        System.out.println(immutableClass.getClass());        
    }
}
