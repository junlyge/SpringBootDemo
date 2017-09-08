package com.lj.test.demo.service;

import com.lj.test.demo.model.LearnResouce;
import com.lj.test.demo.util.PageBean;

import java.util.Map;

public interface ILearnService {
    int add(LearnResouce learnResouce);
    int update(LearnResouce learnResouce);
    int deleteByIds(String ids);
    LearnResouce queryLearnResouceById(Long learnResouce);
    PageBean<LearnResouce> queryLearnResouceList(LearnResouce learnResouceQuery,Integer curPage, Integer pageSize);
}
