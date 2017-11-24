package com.mobin.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

public class Utils {


    public static String getUserID(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 3; i ++){
            sb.append((char)(Math.random()*26 + 65));
        }
        sb.append(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()));
       return  sb.toString();
    }

    public static String generateSecretKey(){
        String secretKey = UUID.randomUUID().toString().replace("-","");
       return  secretKey;
    }
}
