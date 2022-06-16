package com.example.test;

public class detail {

    String date;
    String slot;
    String address;

    public detail(String date, String slot, String address) {
        this.date = date;
        this.slot = slot;
        this.address = address;
    }


    public String getDate() {
        return date;
    }

    public String getSlot() {
        return slot;
    }

    public String getAddress() {
        return address;
    }

}
