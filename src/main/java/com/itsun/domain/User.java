package com.itsun.domain;

import java.io.Serializable;

public class User  implements Serializable {
    private Integer id;
    private String username;
    private int password;

    public Integer getId(int i) {
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

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password=" + password +
                '}';
    }
}
