package com.lj.test.demo.controller;

import com.alibaba.fastjson.JSON;
import com.lj.test.demo.model.LearnResouce;
import com.lj.test.demo.service.ILearnService;
import com.lj.test.demo.util.PageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/learn")
public class LearnController {
    @Autowired
    private ILearnService learnService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/list")
    public ModelAndView list(LearnResouce learnResouceQuery,Integer curPage, Integer pageSize){
        if(null==curPage){
            curPage = 1;
        }
        if(null==pageSize){
            pageSize = 10;
        }
        PageBean<LearnResouce> page = learnService.queryLearnResouceList(learnResouceQuery,curPage,pageSize);
        ModelAndView modelAndView = new ModelAndView("/learnList");
        modelAndView.addObject("page",page);
        return modelAndView;
    }
}
