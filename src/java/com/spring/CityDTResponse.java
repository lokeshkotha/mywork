/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author itdev-9
 */
@XmlRootElement
public class CityDTResponse implements Serializable{

    private String cityid;
    private String cityname;
    private String regionname;
    private String citycode;

    public CityDTResponse() {
    }

    public CityDTResponse(String cityid, String cityname, String regionname, String citycode) {
        this.cityid = cityid;
        this.cityname = cityname;
        this.regionname = regionname;
        this.citycode = citycode;
    }

    @XmlElement
    public String getCityid() {
        return cityid;
    }

    
    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    @XmlElement
    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    @XmlElement
    public String getRegionname() {
        return regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname;
    }

    @XmlElement
    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

}
