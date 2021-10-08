package com.amorsl.springcloud.entities;


public class Payment {
    private int id;
    private String serial;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Payment() {
    }

    public Payment(int id, String serial) {
        this.id = id;
        this.serial = serial;
    }
}
