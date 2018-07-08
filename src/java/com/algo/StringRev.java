/*
 * Iman Tech Solutions,
 * Hyderabad, India
 * 
 */
package com.algo;

/**
 *
 * @author Lokesh Kotha
 */
public class StringRev {

    public static void main(String[] args) {
        System.out.println(reverseString("iman tech")); 
    }

    private static String reverseString(String test) {
        if(test.length()==0)
            return "";
        return test.charAt(test.length()-1)+reverseString(test.substring(0, test.length()-1));
    }

    
}
