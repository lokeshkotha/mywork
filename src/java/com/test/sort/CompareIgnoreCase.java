/*
 * Iman Tech Solutions,
 * Hyderabad, India
 * 
 */
package com.test.sort;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lokesh Kotha
 */
public class CompareIgnoreCase {

    public static void main(String[] args) {
        List<String> fieldNamesList = new ArrayList<String>() {
            @Override
            public boolean contains(Object o) {
                String paramStr = (String) o;
                for (String s : this) {
                    if (paramStr.equalsIgnoreCase(s)) {
                        return true;
                    }
                }
                return false;
            }
        };

    }
}
