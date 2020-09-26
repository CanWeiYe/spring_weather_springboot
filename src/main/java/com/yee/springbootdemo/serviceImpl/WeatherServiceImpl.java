package com.yee.springbootdemo.serviceImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yee.springbootdemo.dao.CityMapper;
import com.yee.springbootdemo.entity.Location;
import com.yee.springbootdemo.entity.ProcessedAlarm;
import com.yee.springbootdemo.entity.ResponseAlarm;
import com.yee.springbootdemo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String getCurrentAlarms(String response){
        List<ResponseAlarm> alarms = JSONObject.parseArray(response,ResponseAlarm.class);
        List<ProcessedAlarm> results = new ArrayList<ProcessedAlarm>();
        for (ResponseAlarm alarm:alarms){
            Location location = cityMapper.selectLocationById(alarm.getId());
            ProcessedAlarm processedAlarm = new ProcessedAlarm();
            processedAlarm.setLocation(location);
            processedAlarm.setAlarm_content(alarm.getAlarm_content());
            processedAlarm.setAlarm_level(alarm.getAlarm_level());
            processedAlarm.setAlarm_type(alarm.getAlarm_type());
            results.add(processedAlarm);
        }
        return JSONArray.toJSONString(results);
    }
}
