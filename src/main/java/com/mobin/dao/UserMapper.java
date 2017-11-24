package com.mobin.dao;

import com.mobin.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public interface UserMapper {
    void createUser(User user);
}
