package com.jsf.testing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author itdev8
 */
public class App {

//    private App[] appArray;
    public static void main(String[] args) {
//        System.out.println(XMLMovingDistance.Auto.getName());
//        System.out.println(XMLMovingDistance.Auto.toString());
//        String incId = "MF1700001";
//        String year = incId.substring(2, 4);
//        String no = incId.substring(4, 9);
//        String test="LOKESH KOTHA NAGA";
//        int i=test.indexOf(" ");
//        String test2=test.substring(0,i);
//        String test3=test.substring(i,test.length());
//        System.out.println(test2);
//        System.out.println(test3);
//        String a = "http://192.168.0.199:8090/";
//        String b = "http://192.168.0.199:8090/html/dmi/smallimage1503143292565.jpg";
//        System.out.println(a.length());
//        System.out.println(b.substring(a.length(), b.length()));
//        System.out.println(b.lastIndexOf("html/"));
//        System.out.println(b.indexOf("html"));
//        App app = new App();
//        System.out.println(app.a());
//        App app = new App();
//        System.out.println(app.a());
//        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
//        map.put("Jan", 1);
//        map.put("Feb", 2);
//        map.put("Mar", 3);
//        map.put("Apr", 4);
//        map.put("May", 5);
//        map.put("Jun", 6);
//        map.put("Jul", 7);
//        map.put("Aug", 8);
//        map.put("Sep", 9);
//        map.put("Oct", 10);
//        map.put("Nov", 11);
//        map.put("Dec", 12);
//        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " value is" + entry.getValue());
//        }
//        Iterator<Map.Entry<String,Integer>> iterator=map.entrySet().iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next().getKey()+" "+iterator.next().getValue());
//        }
//        Integer[] testArray = {198, 2, 3, 4, 5, 6, 7, 4365, 431, 35, 43, 135, 15, 53, 15, 314, 51, 54, 54, 54, 43, 34};
//        Integer[] testArray2 = {198, 2, 3, 4, 5, 6, 7, 4365, 431, 35, 43, 135, 15, 53, 15, 314, 51, 54, 54, 54, 43, 34};
//        int i = Arrays.binarySearch(testArray, 2);
//        boolean i2 = Arrays.equals(testArray, testArray2);
//        Arrays.fill(testArray2, 10);
//        System.out.println(i);
//        System.out.println(i2);
//        System.out.println(Arrays.toString(testArray2));
//        Arrays.sort(testArray);
//        System.out.println(Arrays.toString(testArray));
//        System.out.println(Arrays.deepToString(testArray));
//        char[] copyFrom = {'d', 'e', 'c', 'a', 'f', 'f', 'e',
//            'i', 'n', 'a', 't', 'e', 'd'};
//        char[] copyTo = new char[7];
//        System.arraycopy(copyFrom, 2, copyTo, 0, 7);
//        System.out.println(new String(copyTo));
//        System.out.println("start");
//        char[] addTest = new char[15];
//        for (int j = 0; j < addTest.length; j++) {
//            System.out.println(addTest.length);
//            addTest[j] = 'a';
//        }
//        System.out.println(Arrays.toString(addTest));
//        System.out.println(String.format("%01000d", 0));
//        System.out.print(String.format("%01000d", 0).replace("0", "Lokesh\n"));

    }

    public String a() {
//        return "b";
        try {
            System.out.println("in try");
            throw new NullPointerException();
//            return "a";
        } catch (Exception e) {
            System.out.println("in exception");
//            return "Exception";
        } finally {
            System.out.println("in finally");
//            throw new NullPointerException();
//            return "finally";
        }
        return "skvk";
    }

}
