/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Lokesh Kotha
 */
public class SortPerson {

    public static void main(String[] args) {
        Person person1 = new Person("lokesh", "22");
        Person person2 = new Person("kotha", "23");
        Person person3 = new Person("kntha", "25");
        Person person4 = new Person("waaris", "26");
        Person person5 = new Person("rajesh", "27");
        List<Person> personsList = new ArrayList<Person>();
        personsList.addAll(Arrays.asList(person1, person2, person3, person4, person5));
        Collections.sort(personsList, new Comparator<Person>() {
            @Override
            public int compare(Person t, Person t1) {
                return t.getUsername().compareTo(t1.getUsername());
            }
        });
        
        for(Person person:personsList){
            System.out.println(person.getUsername());
        }
    }

}
