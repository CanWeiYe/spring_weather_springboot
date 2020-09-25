package com.yee.springbootdemo.entity;

public class Location {
    public float lat;
    public float lng;

    @Override
    public String toString() {
        return "{" +
                "lat:" + lat +
                ", lng:" + lng +
                '}';
    }
}
