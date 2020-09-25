package com.yee.springbootdemo.serviceImpl;

import com.yee.springbootdemo.dao.CityMapper;
import com.yee.springbootdemo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {

    private CityMapper cityMapper;

    @Autowired
    public void setCityMapper(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    @Override
    public String getCityId(String cityName) {
        return cityMapper.selectByCityName(cityName);
    }

}
