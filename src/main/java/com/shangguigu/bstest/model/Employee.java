package com.shangguigu.bstest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.Exported;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;


/**
 * @author shkstart
 * @create 2020-02-20 15:42
 */
public class Employee implements Serializable{

    private Integer id;
    private String nick;
    private String phone;
    private String address;
    private String email;
    private Integer gender;
    private Date birth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Employee(int id, String nick, String phone, String address, String email, int gender, Date birth) {
        this.id = id;
        this.nick = nick;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", nick='" + nick + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                '}';
    }
}
