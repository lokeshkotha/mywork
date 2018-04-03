/*
 * Iman Tech Solutions,
 * Hyderabad, India
 * 
 */
package com.hackr;

/**
 *
 * @author Lokesh Kotha
 */
public class ArrayRev {
    //limitations
    //should use only single array
    //special characters positions should be same
    //reverse array

    public static String[] ipArray = new String[]{"A", "B", "@", "C", "%", "D", "&"};

    public static void main(String[] args) {
        int specialCharacterCount = 0;
        for (String content : ipArray) {
            if (content.matches("[^A-Za-z]")) {
                specialCharacterCount++;
            }
        }
        for (int j = ipArray.length; j > 0; j--) {
            if (!ipArray[j].matches("[^A-Za-z]")) {
                ipArray[j] = ipArray[j - specialCharacterCount];
            }
        }
    }
}
