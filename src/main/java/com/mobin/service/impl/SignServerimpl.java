package com.mobin.service.impl;

import com.mobin.service.SignServer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.TreeMap;

@Service
@Transactional
public class SignServerimpl implements SignServer{
    @Override
    public boolean checkSign(TreeMap<String, String> params) {
        long currentTime = System.currentTimeMillis();
        if(null == params.get("sign") || null == params.get("timeStamp") || Long.valueOf(params.get("timeStamp")) - currentTime >60)
            return false;
        for(Map.Entry<String, String> param: params.entrySet()){

        }
        return false;
    }
}
