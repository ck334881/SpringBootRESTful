package com.mobin.controller;

/**
 * Created by Mobin on 2017/11/22.
 */

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户注册之后返回UserID及secret key
 */
@RestController
@RequestMapping(value = "/signUp")
public class SignUpCountroller {
}
