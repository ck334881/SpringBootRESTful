package com.mobin.service;

import java.util.Map;
import java.util.TreeMap;

public interface SignServer {
    boolean checkSign(TreeMap<String,String> params);
}
