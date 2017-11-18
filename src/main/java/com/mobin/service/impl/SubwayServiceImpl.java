package com.mobin.service.impl;

import com.github.pagehelper.PageHelper;
import com.mobin.dao.SubwayMapper;
import com.mobin.entity.Subway;
import com.mobin.service.SubwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mobin on 2017/11/14.
 */
@Service
@Transactional
public class SubwayServiceImpl implements SubwayService {

    @Autowired
    private SubwayMapper subwayMapper;

    public Subway findSubwayByID(int id) {
        return subwayMapper.findSubwayByID(id);
    }

    public List<Subway> findSubways(int pageNum,int  pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return subwayMapper.findSubways();
    }
}
