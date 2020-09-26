package com.yee.springbootdemo.dao;

import com.yee.springbootdemo.entity.City;
import com.yee.springbootdemo.entity.Location;
import org.springframework.stereotype.Repository;

@Repository
public interface CityMapper {
    int deleteByPrimaryKey(String id);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);

    String selectByCityName(String cityName);

    Location selectLocationById(String id);
}
