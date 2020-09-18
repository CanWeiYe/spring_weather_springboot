package com.yee.springbootdemo.entity;

import java.io.Serializable;

public class Student implements Serializable {
    private String sno;

    private String sname;

    private Short age;

    private String phonenumber;

    private String sex;

    public Student(String sno, String sname, Short age, String phonenumber, String sex) {
        this.sno = sno;
        this.sname = sname;
        this.age = age;
        this.phonenumber = phonenumber;
        this.sex = sex;
    }

    public Student() {
        super();
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno == null ? null : sno.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", phonenumber='" + phonenumber + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
