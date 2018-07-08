/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testing;

/**
 *
 * @author Lokesh Kotha
 */
public class ArrayTest {

    public static void main(String[] args) {
        char[] matrix = new char[]{'H', 'e', 'l', 'l', 'o'};
        System.out.println(matrix);
        /* Print each letter of the char array in a separate line. */
        for (int i = 4; i < matrix.length; ++i) {
            int j=i+1;
            System.out.println(matrix[j]);
        }
    }
}
