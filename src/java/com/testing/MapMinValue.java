/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testing;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

/**
 *
 * @author Lokesh Kotha
 */
public class MapMinValue {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("1.1", 0);
        map.put("0.1", 1);
        map.put("2.1", 1);
        //        Double min1 = Collections.max(map.values());
        //        System.out.println(min1);
        //        Stream<Map.Entry<String, Integer>> sorted = map.entrySet().stream().sorted(Map.Entry.comparingByValue());
        //        map.entrySet().stream()
        //                .sorted(Map.Entry.comparingByValue())
        //                .forEach(System.out::println);
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        Map<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
            System.out.println(entry.getKey()+"-"+entry.getValue());
        }
        
//        Entry<String, Double> min = null;
//        for (Entry<String, Double> entry : map.entrySet()) {
//            if (min == null || min.getValue() > entry.getValue()) {
//                min = entry;
//            }
//        }
//        System.out.println(min.getKey());
    }
}
