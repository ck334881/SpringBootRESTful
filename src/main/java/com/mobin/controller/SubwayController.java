package com.mobin.controller;

import com.github.pagehelper.PageInfo;
import com.mobin.dto.SubwayResult;
import com.mobin.entity.Subway;
import com.mobin.exception.EntityNotFoundException;
import com.mobin.service.SubwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.WebMvcProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.ServletRequest;
import java.util.List;

/**
 * Created by Mobin on 2017/11/14.
 */
@RestController
@RequestMapping(value = "/api/subways")
public class SubwayController {

    @Autowired
    private SubwayService subwayService;

    @RequestMapping(value="/{id}",method = RequestMethod.GET )
    public SubwayResult<Subway> getSubwayByID(@PathVariable Integer id) {
        SubwayResult<Subway> result = new SubwayResult();
        Subway subway = subwayService.findSubwayByID(id);
        if (subway == null){
            throw new EntityNotFoundException("资源不存在");
        }
        result.setStatus(HttpStatus.OK.value());
        result.setData(subway);
        return result;
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public SubwayResult<List<Subway>> getSubways(@RequestParam(required = false, defaultValue = "1") int pageNum,
                                                 @RequestParam(required = false, defaultValue = "3")  int pageSize){

        SubwayResult<List<Subway>> subways = new SubwayResult<>();
        List<Subway> sbs = subwayService.findSubways(pageNum, pageSize);
        subways.setData(sbs);
        subways.setStatus(HttpStatus.OK.value());
        return subways;
    }
}
