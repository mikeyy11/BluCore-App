package com.example.blucore;

import java.util.Date;

public class BookingHelperClass {

    String id, serviceType, mobile, name, address, description;
    //Date date;

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /*public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }*/

    public BookingHelperClass(String id, String serviceType, String mobile, String name, String address, String description) {
        this.id = id;
        this.serviceType = serviceType;
        this.mobile = mobile;
        this.name = name;
        this.address = address;
        this.description = description;
       // this.date = date;
    }

    public BookingHelperClass() {
    }
}
