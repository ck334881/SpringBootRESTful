package com.mobin.service;

import com.mobin.VO.UserVO;
import com.mobin.entity.User;

public interface UserService {
    UserVO createUser(User user);
}
