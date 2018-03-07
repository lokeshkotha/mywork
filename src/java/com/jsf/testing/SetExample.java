package com.jsf.testing;


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author itdev8
 */
public class SetExample {

    public static void main(String[] args) {
        System.out.println("Set example .....");
        Set<String> set = new TreeSet<String>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("1");
        set.add("2");
        set.add("5");

        for (String temp : set) {
            System.out.println(temp);
        }
    }

}
