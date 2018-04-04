/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.staticbinding;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 *
 * @author lokesh
 */
public class OverLoad {

    public static void main(String[] args) {
OverLoad load=new OverLoad();
        Collection l=new LinkedList();
        load.find(l);
    }

    public Collection find(Collection c) {
        System.out.println("collection");
        return c;
    }

    public LinkedList find(LinkedList linkedList) {
        System.out.println("linked list");
        return linkedList;
    }

}
