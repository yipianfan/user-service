package com.hunt.user.entry.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class UserVo {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthday;

    public LocalDateTime getBirthday() {return birthday;}

    public void setBirthday(LocalDateTime birthday) {this.birthday = birthday;}
}