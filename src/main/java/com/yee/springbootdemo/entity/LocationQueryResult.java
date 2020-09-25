package com.yee.springbootdemo.entity;

import java.util.Arrays;

public class LocationQueryResult {

    private int status;
    private String message;
    private LocationInfo[] results;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocationInfo[] getResults() {
        return results;
    }

    public void setResults(LocationInfo[] results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "LocationQueryResult{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", results=" + Arrays.toString(results) +
                '}';
    }

    public static class LocationInfo{

        private String name;
        private Location location;
        private String address;
        private String province;
        private String city;
        private String area;
        private String street_id;
        private String telephone;
        private String detail;
        private String uid;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getStreet_id() {
            return street_id;
        }

        public void setStreet_id(String street_id) {
            this.street_id = street_id;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        @Override
        public String toString() {
            return "LocationInfo{" +
                    "name='" + name + '\'' +
                    ", location=" + location +
                    ", address='" + address + '\'' +
                    ", province='" + province + '\'' +
                    ", city='" + city + '\'' +
                    ", area='" + area + '\'' +
                    ", street_id='" + street_id + '\'' +
                    ", telephone='" + telephone + '\'' +
                    ", detail='" + detail + '\'' +
                    ", uid='" + uid + '\'' +
                    '}'+'\n';
        }
    }
}
