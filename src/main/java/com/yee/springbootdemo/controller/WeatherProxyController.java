package com.yee.springbootdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.yee.springbootdemo.entity.LocationQueryResult;
import com.yee.springbootdemo.serviceImpl.WeatherServiceImpl;
import com.yee.springbootdemo.utils.BaiduLocationUtil;
import com.yee.springbootdemo.utils.IpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
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
    private static ThreadLocal<String> cityIdThreadLocal = new ThreadLocal<String>();
    private static ThreadLocal<String> ipThreadLocal = new ThreadLocal<String>();
    private RestTemplate restTemplate;
    private WeatherServiceImpl weatherService;
    @Value("${OpenWeatherApi.appid}")
    private String appId;
    @Value("${OpenWeatherApi.appsecret}")
    private String appSecret;

    /**
     * I'm free
     * @param useIp 是否使用ip
     * @param keyword   搜索关键词
     * @param request   获取ip
     * @return
     */
    @RequestMapping("/current/weather")
    public JSONObject getCurrentWeather(@RequestParam(name = "useIp",defaultValue = "false")boolean useIp
                                        ,String keyword,HttpServletRequest request){
        if (useIp){
            String ip = IpUtil.getIpAddr(request);
            WeatherProxyController.ipThreadLocal.set(ip);
            if (logger.isDebugEnabled()){
                logger.debug("current:"+ip);
            }
            ResponseEntity<String> exchange = restTemplate.exchange("http://www.tianqiapi.com/api?version=v61&appid={appid}&appsecret={appsecret}&ip={ip}", HttpMethod.GET, null,
                    String.class,appId,appSecret,ip);
            String response = exchange.getBody();
            return JSONObject.parseObject(response);
        }
        else{
            LocationQueryResult queryResult = BaiduLocationUtil.getLocation(keyword);
            LocationQueryResult.LocationInfo[] locationInfo = queryResult.getResults();
            String cityName = BaiduLocationUtil.resolveArea(locationInfo[0]);
            if (logger.isDebugEnabled()){
                logger.debug("current:"+cityName);
            }
            String cityId = weatherService.getCityId(cityName);
            WeatherProxyController.cityIdThreadLocal.set(cityId);
            ResponseEntity<String> exchange = restTemplate.exchange("http://www.tianqiapi.com/api?version=v61&appid={appid}&appsecret={appsecret}&cityid={cityid}", HttpMethod.GET, null,
                    String.class,appId,appSecret,cityId);
            String response = exchange.getBody();
            return JSONObject.parseObject(response);
        }
    }

    /**
     * I'm free
     * @param useIp 是否使用ip
     * @param keyword   搜索关键词
     * @param request   获取ip
     * @return
     */
    @RequestMapping("/forecast/weather")
    public JSONObject getForecastWeather(@RequestParam(name = "useIp",defaultValue = "false")boolean useIp
            ,String keyword,HttpServletRequest request){
        if (useIp){
            String ip = WeatherProxyController.ipThreadLocal.get();
            WeatherProxyController.ipThreadLocal.remove();
            ResponseEntity<String> exchange = restTemplate.exchange("http://www.tianqiapi.com/api?version=v9&appid={appid}&appsecret={appsecret}&ip={ip}", HttpMethod.GET, null,
                    String.class,appId,appSecret,ip);
            String response = exchange.getBody();
            return JSONObject.parseObject(response);
        }
        else{
            String cityId = WeatherProxyController.cityIdThreadLocal.get();
            WeatherProxyController.cityIdThreadLocal.remove();
            ResponseEntity<String> exchange = restTemplate.exchange("http://www.tianqiapi.com/api?version=v9&appid={appid}&appsecret={appsecret}&cityid={cityid}", HttpMethod.GET, null,
                    String.class,appId,appSecret,cityId);
            String response = exchange.getBody();
            return JSONObject.parseObject(response);
        }
    }

    @RequestMapping("/forecast/precipitation")
    public String getPrecipitationForecast(){
        ResponseEntity<String> exchange = restTemplate.exchange("http://www.tianqiapi.com/api?version=v8&appid={appid}&appsecret={appsecret}", HttpMethod.GET, null,
                String.class,appId,appSecret);
        return exchange.getBody();
    }

    @RequestMapping("/alarms")
    @Cacheable(key = "'alarms'",value = "MyCache_Expire_3h")
    public String getAlarms(){
        ResponseEntity<String> exchange = restTemplate.exchange("http://www.tianqiapi.com/api?version=v7&appid={appid}&appsecret={appsecret}", HttpMethod.GET, null,
                String.class,appId,appSecret);
        String response = exchange.getBody();
        return weatherService.getCurrentAlarms(response);
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    public void setWeatherService(WeatherServiceImpl weatherService) {
        this.weatherService = weatherService;
    }
}
