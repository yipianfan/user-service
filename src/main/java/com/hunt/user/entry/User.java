package com.hunt.user.entry;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class User {
    private Long id;
    private String userName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthday;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getUserName() {return userName;}

    public void setUserName(String userName) {this.userName = userName;}

    public LocalDateTime getBirthday() {return birthday;}

    public void setBirthday(LocalDateTime birthday) {this.birthday = birthday;}
}