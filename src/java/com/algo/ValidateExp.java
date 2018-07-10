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
public class ValidateExp {

    private static String input = "[]{{[]}[]()}";

    public static void main(String[] args) {
        System.out.println(validateStringExp(input));
        char[] ip=input.toCharArray();
        System.out.println(ip.length);
    }

    private static boolean validateStringExp(String input) {
        return true;
    }
}
