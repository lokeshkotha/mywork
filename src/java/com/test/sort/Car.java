/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.sort;

/**
 *
 * @author Lokesh Kotha
 */
public class Car {

    private String carName;
    private String model;

    public Car() {
    }

    public Car(String carName, String model) {
        this.carName = carName;
        this.model = model;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (this.carName != null ? this.carName.hashCode() : 0);
        hash = 41 * hash + (this.model != null ? this.model.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Car other = (Car) obj;
        if ((this.carName == null) ? (other.carName != null) : !this.carName.equals(other.carName)) {
            return false;
        }
        if ((this.model == null) ? (other.model != null) : !this.model.equals(other.model)) {
            return false;
        }
        return true;
    }

}
