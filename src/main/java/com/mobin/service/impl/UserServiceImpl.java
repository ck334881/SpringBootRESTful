package com.mobin.service.impl;

import com.mobin.VO.UserVO;
import com.mobin.dao.UserMapper;
import com.mobin.entity.User;
import com.mobin.service.UserService;
import com.mobin.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserVO createUser(User user) {
        String userID = generateUserID();
        String secrestKey = generateSecretKey();
        user.setUserID(userID);
        user.setSecretKey(secrestKey);
        UserVO userVO = new UserVO();
        userVO.setSecretKey(secrestKey);
        userVO.setUserID(userID);
        userVO.setUserName(user.getUserName());
        userMapper.createUser(user);
        return userVO;
    }



    /**
     * UserID = 三个随机字母 + yyyyMMddHHmmssSSS + 6位随机数
     * @return
     */
    public String generateUserID(){
        return Utils.getUserID();
    }


    public String generateSecretKey(){
        return Utils.generateSecretKey();
    }
}
