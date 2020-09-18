package com.yee.springbootdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.yee.springbootdemo.utils.IpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
public class WeatherProxyController {

    private static final Logger logger = LoggerFactory.getLogger(WeatherProxyController.class);
    @Autowired
    private RestTemplate restTemplate;
    @Value("${OpenWeatherApi.appid}")
    private String appId;
    @Value("${OpenWeatherApi.appsecret}")
    private String appSecret;

    @RequestMapping("/current/weather")
    public JSONObject getCurrentWeather(@RequestParam(name = "useIp",defaultValue = "false")boolean useIp
                                        ,String keyword,HttpServletRequest request){
        if (useIp){
            String ip = IpUtil.getIpAddr(request);
            if (logger.isDebugEnabled()){
                logger.debug(ip);
            }
            ResponseEntity<String> exchange = restTemplate.exchange("http://www.tianqiapi.com/api?version=v6&appid={appid}&appsecret={appsecret}&ip={ip}", HttpMethod.GET, null,
                    String.class,appId,appSecret,ip);
            String response = exchange.getBody();
            return JSONObject.parseObject(response);
        }
        return null;
    }

    @RequestMapping("/forecast/precipitation")
    public String getPrecipitationForecast(){
        ResponseEntity<String> exchange = restTemplate.exchange("http://www.tianqiapi.com/api?version=v8&appid={appid}&appsecret={appsecret}", HttpMethod.GET, null,
                String.class,appId,appSecret);
        return exchange.getBody();
    }

}
