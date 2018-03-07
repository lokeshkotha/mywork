/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mongo.location;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

/**
 *
 * @author itdev7
 */
public class Restaurants implements Serializable {

    private String _id;
    private String restaurantName;
    private String contactPerson;
    private String address;
    private String contactNumber;
    private String email;
    private Country country;
    private Regions regions;
    private City city;
    private Areas areas;
    private String pincode;
    private Integer noofTables;
    private Integer noofMenuItems;
    private Boolean isActive;
    private Double serviceStars;
    private List<PaymentModes> paymentModesList;
    private String latitude;
    private String longitude;
    private Boolean emailVerified;
    private Boolean mobileVerified;
    private String otp;
    private GeoJsonPoint geoJsonPoint;
    private String cuisinType;
    private String averageDeliveryTime;

    public Restaurants() {
    }

    public GeoJsonPoint getGeoJsonPoint() {
        return geoJsonPoint;
    }

    public void setGeoJsonPoint(GeoJsonPoint geoJsonPoint) {
        this.geoJsonPoint = geoJsonPoint;
    }

    public String getCuisinType() {
        return cuisinType;
    }

    public void setCuisinType(String cuisinType) {
        this.cuisinType = cuisinType;
    }

    public String getAverageDeliveryTime() {
        return averageDeliveryTime;
    }

    public void setAverageDeliveryTime(String averageDeliveryTime) {
        this.averageDeliveryTime = averageDeliveryTime;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public Boolean getMobileVerified() {
        return mobileVerified;
    }

    public void setMobileVerified(Boolean mobileVerified) {
        this.mobileVerified = mobileVerified;
    }

    public Double getServiceStars() {
        return serviceStars;
    }

    public void setServiceStars(Double serviceStars) {
        this.serviceStars = serviceStars;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Regions getRegions() {
        return regions;
    }

    public void setRegions(Regions regions) {
        this.regions = regions;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Areas getAreas() {
        return areas;
    }

    public void setAreas(Areas areas) {
        this.areas = areas;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public Integer getNoofTables() {
        return noofTables;
    }

    public void setNoofTables(Integer noofTables) {
        this.noofTables = noofTables;
    }

    public Integer getNoofMenuItems() {
        return noofMenuItems;
    }

    public void setNoofMenuItems(Integer noofMenuItems) {
        this.noofMenuItems = noofMenuItems;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public List<PaymentModes> getPaymentModesList() {
        return paymentModesList;
    }

    public void setPaymentModesList(List<PaymentModes> paymentModesList) {
        this.paymentModesList = paymentModesList;
    }

}
