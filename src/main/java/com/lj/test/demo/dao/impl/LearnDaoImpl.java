package com.lj.test.demo.dao.impl;

import com.lj.test.demo.dao.ILearnDao;
import com.lj.test.demo.model.LearnResouce;
import com.lj.test.demo.util.PageBean;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LearnDaoImpl implements ILearnDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(LearnResouce learnResouce) {
        return jdbcTemplate.update("insert into learn_resource(author, title,url) values(?, ?, ?)",learnResouce.getAuthor(),learnResouce.getTitle(),learnResouce.getUrl());
    }

    @Override
    public int update(LearnResouce learnResouce) {
        return jdbcTemplate.update("update learn_resource set author=?,title=?,url=? where id = ?",new Object[]{learnResouce.getAuthor(),learnResouce.getTitle(),learnResouce.getUrl(),learnResouce.getId()});
    }

    @Override
    public int deleteByIds(String ids){
        return jdbcTemplate.update("delete from learn_resource where id in("+ids+")");
    }

    @Override
    public LearnResouce queryLearnResouceById(Long id) {
        List<LearnResouce> list = jdbcTemplate.query("select * from learn_resource where id = ?", new Object[]{id}, new BeanPropertyRowMapper(LearnResouce.class));
        if(null != list && list.size()>0){
            LearnResouce learnResouce = list.get(0);
            return learnResouce;
        }else{
            return null;
        }
    }

    public List<LearnResouce> queryLearnResouceList(String sql){
        List<LearnResouce> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper(LearnResouce.class));
        return list;
    }

    public int selectCount(String sql){
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

}
