package com.shangguigu.bstest.model;

import java.io.Serializable;

/**
 * @author shkstart
 * @create 2019-11-07 17:52
 */
public class User implements Serializable {

    private String userName;
    private String password;
    private int id;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User() {
    }

    public User(String userName, String password, int id) {
        this.userName = userName;
        this.password = password;
        this.id = id;
    }
}
