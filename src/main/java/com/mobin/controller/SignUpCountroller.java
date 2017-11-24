package com.mobin.controller;

/**
 * Created by Mobin on 2017/11/22.
 */

import com.mobin.VO.UserVO;
import com.mobin.entity.User;
import com.mobin.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户注册之后返回UserID及secret key
 */
@RestController
@RequestMapping(value = "/signUp")
public class SignUpCountroller {
    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.POST)
    public UserVO signUp(){
        User user = new User();
        user.setUserName("mobin");
        //TODO 加密
        user.setPassWord("154283");
       return service.createUser(user);
    }
}
