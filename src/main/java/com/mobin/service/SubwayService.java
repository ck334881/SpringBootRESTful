package com.mobin.service;

import com.mobin.entity.Subway;

import java.util.List;

/**
 * Created by Mobin on 2017/11/14.
 */
public interface SubwayService {
    Subway findSubwayByID(int id);
    List<Subway> findSubways(int pageNum, int pageSize);
}
