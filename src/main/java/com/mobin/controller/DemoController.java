package com.mobin.controller;

import com.mobin.entity.ErrorMessage;
import com.mobin.exception.URLIllegalArgumentException;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Mobin on 2017/11/15.
 */
@RestController
public class DemoController {
    @RequestMapping("/hello")
    public String showHello(){
        throw  new URLIllegalArgumentException("mobin");
    }
}
