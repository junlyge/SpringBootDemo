package com.lj.test.demo.dao;

import com.lj.test.demo.model.LearnResouce;
import com.lj.test.demo.util.PageBean;

import java.net.Inet4Address;
import java.util.List;
import java.util.Map;

public interface ILearnDao {
    int add(LearnResouce learnResouce);
    int update(LearnResouce learnResouce);
    int deleteByIds(String ids);
    LearnResouce queryLearnResouceById(Long id);
    List<LearnResouce> queryLearnResouceList(String sql);
    int selectCount(String sql);
}
