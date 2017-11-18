package com.mobin.dao;

import com.mobin.entity.Subway;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Mobin on 2017/11/14.
 */
@Mapper
public interface SubwayMapper {
     Subway findSubwayByID(int id);
     List<Subway> findSubways();
}
