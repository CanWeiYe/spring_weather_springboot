package com.yee.springbootdemo.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Response {
    private int code;
    private String message;
    private Map data = new HashMap();

    private Response(){}

    public static Response success(){
        return new Response().setCode(20000);
    }

    public static Response fail(){
        return new Response().setCode(40000);
    }

    public int getCode() {
        return code;
    }

    public Response setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Response setMessage(String message) {
        this.message = message;
        return this;
    }

    public Map getData() {
        return data;
    }

    public Response setData(String key, List value) {
        data.put(key,value);
        return this;
    }
}
