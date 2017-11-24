package com.mobin.common;

/**
 * 001：成功
 * 002：资源不存在
 * 003：参数异常
 */


public enum StatusCode {
    BX001(001,"OK"),
    BXOO2(002,"资源不存在"),
    BX003(003,"参数异常");
    private int statusCode;
    private String message;
    StatusCode(int statusCode,String message){
        statusCode = statusCode;
        message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
