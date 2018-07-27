/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algo;

/**
 *
 * @author lokesh
 */
public class ArrRev {

    private static String[] ipChars = new String[]{"D", "@", "B", "$", "C", "w", "$"};
    private static String ipString = "D@B$Cw$";

    public static void main(String[] args) {
        System.out.println(reverseString(ipString));
    }

    private static String reverseString(String s) {
        if (s.equals("")) {
            return "";
        }
        String output;
        if (isSpecialCharacter(s.charAt(s.length() - 1))) {
            output = s.charAt(s.length() - 1) + reverseString(s.substring(0, s.length() - 1));
        } else {
            output = s.charAt(s.length() - 1) + reverseString(s.substring(0, s.length() - 1));
        }
        return output;
    }

    private static boolean isSpecialCharacter(Character c) {
        return c != 32
                && //not a space 
                (c < 48 || c > 57)
                && //not a digit
                (c < 65 || c > 90)
                && //not an uppercase alphabet
                (c < 97 || c > 122);	//not a lowercase alphabet
    }

}
// int j = 0;
//        int k = ipChars.length;
//        for (int i = 0; i < k; i++) {
//            String firstChar = ipChars[i];
//            Boolean dupChecker = false;
//            j = i + 1;
//            if (ipChars[i + 1].matches("[^A-Za-z]")) {
//                j = j + 1;
//                dupChecker = true;
//            }
//            if (j >= k) {
//                k = i - 1;
//                i = -1;
//                continue;
//            }
//            String secondChar = ipChars[j];
//            ipChars[i] = secondChar;
//            ipChars[j] = firstChar;
//            System.out.println(Arrays.toString(ipChars));
//            if (dupChecker) {
//                i = i + 1;
//            }
//        }
