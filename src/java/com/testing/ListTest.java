/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testing;

import com.mongo.location.City;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Lokesh Kotha
 */
public class ListTest {

    public static void main(String[] args) {
        City city1 = new City("id", "HYD", null);
        List<City> citiesList = new ArrayList<>();
        citiesList.add(city1);
        citiesList.add(new City("id", "HYD2", null));
        citiesList.add(new City("id1", "VJA", null));
        citiesList.add(new City("id2", "VSKP", null));
        citiesList.add(new City("id3", "AMP", null));
        citiesList.add(new City("id4", "RJY", null));
//        LinkedList<City> citiesLinkedList=(LinkedList<City>)citiesList;
        Iterator<City> cityIterator = citiesList.iterator();
        while (cityIterator.hasNext()) {
            City city = cityIterator.next();
            if (city.getCityName().equals("HYD")) {
                cityIterator.remove();
            }
        }
//        for (City city : citiesList) {
//            if (city.getCityName().equals("HYD")) {
//                citiesList.remove(city);
//            }
//        }
    }
}
