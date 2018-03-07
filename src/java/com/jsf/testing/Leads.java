/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf.testing;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author itdev7
 */
public class Leads implements Serializable {

    private String _id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String fromZipcode;
    private String toZipcode;
    private String fromAreaName;
    private String toAreaName;
    private String fromCountry;
    private String toCountry;
    private String addlComments;
//    private MovingSizes movingSizes;
    private Date movingDate;
//    private Distance distanceObj;
//    private Services servicesObj;
    private String vehicleBodyTypes;
    private String vehicleMakes;
    private String vehicleModels;
    private String year;
//    private Partners partners;
//    private LeadStatus leadStatus;
//    private Users createdBy;
//    private Users approvedBy;
    private Date approvedDate;
    private Date createdDate;
//    private LeadSource leadSource;
    private String toCity;

    public Leads() {
    }

    public String getFromCountry() {
        return fromCountry;
    }

    public void setFromCountry(String fromCountry) {
        this.fromCountry = fromCountry;
    }

    public String getToCountry() {
        return toCountry;
    }

    public void setToCountry(String toCountry) {
        this.toCountry = toCountry;
    }

    public String getVehicleBodyTypes() {
        return vehicleBodyTypes;
    }

    public void setVehicleBodyTypes(String vehicleBodyTypes) {
        this.vehicleBodyTypes = vehicleBodyTypes;
    }

    public String getVehicleMakes() {
        return vehicleMakes;
    }

    public void setVehicleMakes(String vehicleMakes) {
        this.vehicleMakes = vehicleMakes;
    }

    public String getVehicleModels() {
        return vehicleModels;
    }

    public void setVehicleModels(String vehicleModels) {
        this.vehicleModels = vehicleModels;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFromZipcode() {
        return fromZipcode;
    }

    public void setFromZipcode(String fromZipcode) {
        this.fromZipcode = fromZipcode;
    }

    public String getToZipcode() {
        return toZipcode;
    }

    public void setToZipcode(String toZipcode) {
        this.toZipcode = toZipcode;
    }

    public String getFromAreaName() {
        return fromAreaName;
    }

    public void setFromAreaName(String fromAreaName) {
        this.fromAreaName = fromAreaName;
    }

    public String getToAreaName() {
        return toAreaName;
    }

    public void setToAreaName(String toAreaName) {
        this.toAreaName = toAreaName;
    }

    public String getAddlComments() {
        return addlComments;
    }

    public void setAddlComments(String addlComments) {
        this.addlComments = addlComments;
    }

    public Date getMovingDate() {
        return movingDate;
    }

    public void setMovingDate(Date movingDate) {
        this.movingDate = movingDate;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

}
