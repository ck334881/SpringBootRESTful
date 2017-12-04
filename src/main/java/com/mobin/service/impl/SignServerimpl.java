package com.mobin.service.impl;

import com.mobin.dao.UserMapper;
import com.mobin.exception.ParamsException;
import com.mobin.service.SignServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

@Service
@Transactional
public class SignServerimpl implements SignServer{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public boolean checkSign(TreeMap<String, String> params) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        long currentTime = System.currentTimeMillis();
        if(null == params.get("key") || "".equals(params.get("key").trim())
                || null == params.get("sign") || "".equals(params.get("sign").trim())
                || null == params.get("timeStamp") || "".equals(params.get("timeStamp").trim())
                || Long.valueOf(params.get("timeStamp")) - currentTime >60){
            new ParamsException();
        }
        for(Map.Entry<String, String> param: params.entrySet()){
            sb.append(param.getKey()).append("=").append(param.getValue().trim());
        }
        String secretKey = findSecretKeyByUserID(params.get("key"));
        if (sb.length() > 0){
            sb.append(secretKey);
        }
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] bytes = md5.digest(sb.toString().getBytes("UTF-8"));
        String sign = new BASE64Encoder().encode(bytes);
        if (sign.equals(params.get("sign"))){
            return true;
        }
        return false;
    }

    //根据USERID获取对应的secretKey，从redis中获取
    public String findSecretKeyByUserID(String userID){
        ValueOperations cache = redisTemplate.opsForValue();
        boolean key = redisTemplate.hasKey(userID);
        if (key) {
            return  cache.get(userID).toString();
        }
        String secretkey = userMapper.findSecretKeyByUserID(userID);
        cache.set(userID, secretkey);
        return secretkey;
    }
}
