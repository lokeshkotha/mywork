/*
 * Iman Tech Solutions,
 * Hyderabad, India
 * 
 */
package com.spring;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author Lokesh Kotha
 */
@XmlRootElement
@XmlSeeAlso({CityDTResponse.class})
public class CitiesList<T> {

    private List<T> listOfEntityObjects;

    public CitiesList() {
        listOfEntityObjects = new ArrayList<T>();
    }

    public CitiesList(List<T> listOfEntityObjects) {
        this.listOfEntityObjects = listOfEntityObjects;
    }

    @XmlAnyElement
    public List<T> getItems() {
        return listOfEntityObjects;
    }
}
