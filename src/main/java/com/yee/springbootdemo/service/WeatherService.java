package com.yee.springbootdemo.service;

public interface WeatherService {

    String getCityId(String cityName);

    String getCurrentAlarms(String response);
}
