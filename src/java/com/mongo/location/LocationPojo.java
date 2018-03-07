/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongo.location;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

/**
 *
 * @author Lokesh Kotha
 */
public class LocationPojo {

    private String locationName;
    private GeoJsonPoint geoJsonPoint;

    public LocationPojo() {
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public GeoJsonPoint getGeoJsonPoint() {
        return geoJsonPoint;
    }

    public void setGeoJsonPoint(GeoJsonPoint geoJsonPoint) {
        this.geoJsonPoint = geoJsonPoint;
    }

}
