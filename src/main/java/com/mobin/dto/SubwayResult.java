package com.mobin.dto;

/**
 * Created by Mobin on 2017/11/14.
 */
public class SubwayResult<T> {
    private int status;
    private String message = "SUCCESS";
    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
