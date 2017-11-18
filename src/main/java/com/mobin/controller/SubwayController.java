package com.mobin.controller;

import com.github.pagehelper.PageInfo;
import com.mobin.dto.SubwayResult;
import com.mobin.entity.Subway;
import com.mobin.service.SubwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Mobin on 2017/11/14.
 */
@RestController
@RequestMapping(value = "/subways")
public class SubwayController {

    @Autowired
    private SubwayService subwayService;

    @RequestMapping(value="/{id}",method = RequestMethod.GET )
    public SubwayResult<Subway> getSubwayByID(@PathVariable Integer id){
        SubwayResult<Subway> result = new SubwayResult();
        Subway subway = subwayService.findSubwayByID(id);
        result.setData(subway);
        System.out.println(HttpStatus.OK.value());
        result.setStatus(HttpStatus.OK.value());
        return result;
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public SubwayResult<List<Subway>> getSubways(@RequestParam(required = false) int pageNum,
                                                 @RequestParam(required = false)  int pageSize){

        SubwayResult<List<Subway>> subways = new SubwayResult<>();
        List<Subway> sbs = subwayService.findSubways(pageNum, pageSize);
        subways.setData(sbs);
        subways.setStatus(HttpStatus.OK.value());
        return subways;
    }
}
