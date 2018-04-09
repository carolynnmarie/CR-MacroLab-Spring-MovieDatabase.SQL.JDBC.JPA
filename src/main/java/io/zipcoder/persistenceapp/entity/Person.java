package io.zipcoder.persistenceapp.entity;

import java.sql.Date;

public class Person {
    private Integer id;
    private String first_name;
    private String last_name;
    private String mobile;
    private String birthday;
    private Integer home_id;


    public Person(String last_name, String first_name, String mobile, String birthday, Integer home_id, Integer id) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.mobile = mobile;
        this.birthday = birthday;
        this.home_id = home_id;
        this.id = id;
    }

    public Person(){}

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getHome_id() {
        return home_id;
    }

    public void setHome_id(Integer home_id) {
        this.home_id = home_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "last_name: " + last_name + ", first_name: " + first_name + ", mobile: " + mobile + ", home_id: " +
                home_id;
    }
}
