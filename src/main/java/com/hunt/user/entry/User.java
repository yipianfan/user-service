package com.hunt.user.entry;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
    private Long id;
    private String userName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    private Date addTime;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getUserName() {return userName;}

    public void setUserName(String userName) {this.userName = userName;}

    public Date getBirthday() {return birthday;}

    public void setBirthday(Date birthday) {this.birthday = birthday;}

    public Date getAddTime() {return addTime;}

    public void setAddTime(Date addTime) {this.addTime = addTime;}
}