package com.example.blucore;

public class Booking {
    private String address;
    private String description;
    private String id;
    private String mobile;
    private String name;
    private String serviceType;
    //private String bookingId;
    //private String date;
    private int status;

    // No-argument constructor (needed for Firebase)
    public Booking() {
        // Required empty constructor
    }

    public Booking(String address, String description, String id, String mobile, String serviceType, int status
                   ) {  // String bookingId, String date, String status
        this.address = address;
        this.description = description;
        this.id = id;
        this.mobile = mobile;
        this.serviceType = serviceType;
//        this.bookingId = bookingId;
//        this.date = date;
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public String getMobile() {
        return mobile;
    }

    public String getName() {
        return name;
    }

    public String getServiceType() {
        return serviceType;
    }

    /*public String getBookingId() {
        return bookingId;
    }

    public String getDate() {
        return date;
    }*/

    public int getStatus() {
        return status;
    }
}
