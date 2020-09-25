package com.yee.springbootdemo.entity;

public class City {
    private String id;

    private String cityen;

    private String cityzh;

    private String provinceen;

    private String provincezh;

    private String countryen;

    private String countryzh;

    private String leaderen;

    private String leaderzh;

    private String lat;

    private String lon;

    public City(String id, String cityen, String cityzh, String provinceen, String provincezh, String countryen, String countryzh, String leaderen, String leaderzh, String lat, String lon) {
        this.id = id;
        this.cityen = cityen;
        this.cityzh = cityzh;
        this.provinceen = provinceen;
        this.provincezh = provincezh;
        this.countryen = countryen;
        this.countryzh = countryzh;
        this.leaderen = leaderen;
        this.leaderzh = leaderzh;
        this.lat = lat;
        this.lon = lon;
    }

    public City() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCityen() {
        return cityen;
    }

    public void setCityen(String cityen) {
        this.cityen = cityen == null ? null : cityen.trim();
    }

    public String getCityzh() {
        return cityzh;
    }

    public void setCityzh(String cityzh) {
        this.cityzh = cityzh == null ? null : cityzh.trim();
    }

    public String getProvinceen() {
        return provinceen;
    }

    public void setProvinceen(String provinceen) {
        this.provinceen = provinceen == null ? null : provinceen.trim();
    }

    public String getProvincezh() {
        return provincezh;
    }

    public void setProvincezh(String provincezh) {
        this.provincezh = provincezh == null ? null : provincezh.trim();
    }

    public String getCountryen() {
        return countryen;
    }

    public void setCountryen(String countryen) {
        this.countryen = countryen == null ? null : countryen.trim();
    }

    public String getCountryzh() {
        return countryzh;
    }

    public void setCountryzh(String countryzh) {
        this.countryzh = countryzh == null ? null : countryzh.trim();
    }

    public String getLeaderen() {
        return leaderen;
    }

    public void setLeaderen(String leaderen) {
        this.leaderen = leaderen == null ? null : leaderen.trim();
    }

    public String getLeaderzh() {
        return leaderzh;
    }

    public void setLeaderzh(String leaderzh) {
        this.leaderzh = leaderzh == null ? null : leaderzh.trim();
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon == null ? null : lon.trim();
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", cityen='" + cityen + '\'' +
                ", cityzh='" + cityzh + '\'' +
                ", provinceen='" + provinceen + '\'' +
                ", provincezh='" + provincezh + '\'' +
                ", countryen='" + countryen + '\'' +
                ", countryzh='" + countryzh + '\'' +
                ", leaderen='" + leaderen + '\'' +
                ", leaderzh='" + leaderzh + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                '}';
    }
}
