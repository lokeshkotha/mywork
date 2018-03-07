/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testing;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lokesh Kotha
 */
public class NumbersTest {

    private static List<NumberRanges> rangesList;
    private static int min;
    private static int max;

    public NumbersTest() {
    }

    public static void main(String[] args) {
        min = 0;
        max = 0;
        rangesList = new ArrayList<>();
        rangesList.add(new NumberRanges(0, 100));
        rangesList.add(new NumberRanges(75, 750));
        for (int i = 0; i < rangesList.size(); i++) {
            if (rangesList.get(i).getMin() < min) {
                min = rangesList.get(i).getMin();
            }
            if (rangesList.get(i).getMax() < min) {
                min = rangesList.get(i).getMax();
            }
            if (rangesList.get(i).getMin() > max) {
                max = rangesList.get(i).getMin();
            }
            if (rangesList.get(i).getMax() > max) {
                max = rangesList.get(i).getMax();
            }
        }
        System.out.println(min);
        System.out.println(max);
    }

}
