/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackr;

import java.util.Arrays;

/**
 *
 * @author lokesh
 */
public class ArrRev {

    private static String[] ipChars = new String[]{"D", "@", "B", "$", "C", "w", "$"};

    public static void main(String[] args) {
//        int splCharCount = 0;
//        int charsCount = 0;
//        for (String content : ipChars) {
//            if (content.matches("[^A-Za-z]")) {
//                splCharCount++;
//            } else {
//                charsCount++;
//            }
//        }
//        System.out.println(splCharCount);
//        for (int i = ipChars.length; i > 0; i--) {
//            if (!ipChars[i].matches("[^A-Za-z]")) {
//                String firstOne = ipChars[i];
//                String secondOne = ipChars[ipChars.length - splCharCount];
//                ipChars[i] = ipChars[i];
//            }
//        }
        int j = 0;
        int k = ipChars.length;
        for (int i = 0; i < k; i++) {
            String firstChar = ipChars[i];
            Boolean dupChecker = false;
            j = i + 1;
            if (ipChars[i + 1].matches("[^A-Za-z]")) {
                j = j + 1;
                dupChecker = true;
            }
            if (j >= k) {
                k = i - 1;
                i = -1;
                continue;
            }
            String secondChar = ipChars[j];
            ipChars[i] = secondChar;
            ipChars[j] = firstChar;
            System.out.println(Arrays.toString(ipChars));
            if (dupChecker) {
                i = i + 1;
            }
        }
    }
}
