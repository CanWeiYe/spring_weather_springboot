package com.yee.springbootdemo.utils;

import com.alibaba.fastjson.JSONObject;
import com.yee.springbootdemo.entity.LocationQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BaiduLocationUtil {

    private static RestTemplate restTemplate;
    private static String AK;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate){
        BaiduLocationUtil.restTemplate = restTemplate;
    }

    @Value("${BaiduLocation.AK}")
    public void setAK(String Ak){
        BaiduLocationUtil.AK = Ak;
    }

    /**
     * 返回处理后的城市名字，如杭州、上海
     * @param locationInfo
     * @return
     */
    public static String resolveArea(LocationQueryResult.LocationInfo locationInfo) {
        String city = locationInfo.getArea() == null? locationInfo.getName() : locationInfo.getArea();
        return city.substring(0, city.length()-1);
    }

    public static LocationQueryResult getLocation(String keyword){
        ResponseEntity<String> exchange = restTemplate.exchange("http://api.map.baidu.com/place/v2/search?query={keyword}&region=全国&output=json&ak={AK}", HttpMethod.GET, null,
                String.class,keyword,BaiduLocationUtil.AK);
        String response = exchange.getBody();
        LocationQueryResult result = JSONObject.parseObject(response,LocationQueryResult.class);
        return result;
    }
}
