/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.sort;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lokesh Kotha
 */
public class ReplaceInList {

    public static void main(String[] args) {
        List<Car> listOfCars = new ArrayList<Car>();
        listOfCars.add(new Car("Tesla", "Model s"));
        listOfCars.add(new Car("Aston", "Martin"));
        listOfCars.add(new Car("Lambo", "SV"));
        for (int i = 0; i < listOfCars.size(); i++) {
            if (listOfCars.get(i).getCarName().equals("Aston")) {
                listOfCars.set(i, new Car("martin", "Aston"));
            }
        }
        for (Car car : listOfCars) {
            System.out.println(car.getCarName());
        }
    }

}
