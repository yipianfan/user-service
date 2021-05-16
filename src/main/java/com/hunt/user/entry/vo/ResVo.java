package com.hunt.user.entry.vo;

public class ResVo<T> {
    private int code;
    private String msg;
    private T data;

    public ResVo() {
        this.code = 0;
        this.msg = "";
    }

    public int getCode() {return code;}

    public void setCode(int code) {this.code = code;}

    public String getMsg() {return msg;}

    public void setMsg(String msg) {this.msg = msg;}

    public T getData() {return data;}

    public void setData(T data) {this.data = data;}
}