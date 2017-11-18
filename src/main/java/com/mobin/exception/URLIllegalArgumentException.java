package com.mobin.exception;

/**
 * Created by Mobin on 2017/11/16.
 */
public class URLIllegalArgumentException extends RuntimeException{
    public URLIllegalArgumentException(String arg){
        super(arg + "参数格式不对");
    }
}
