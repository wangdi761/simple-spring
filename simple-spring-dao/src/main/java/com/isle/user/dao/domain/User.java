package com.isle.user.dao.domain;

import java.io.Serializable;

/**
 * Created by 61066 on 2017/12/27.
 */
public class User implements Serializable {

    private Integer id;

    private String username;

    private String password;

    private String realname;

    private String enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }
}
