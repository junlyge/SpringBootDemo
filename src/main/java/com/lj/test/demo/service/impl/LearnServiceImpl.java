package com.lj.test.demo.service.impl;

import com.lj.test.demo.dao.ILearnDao;
import com.lj.test.demo.model.LearnResouce;
import com.lj.test.demo.service.ILearnService;
import com.lj.test.demo.util.PageBean;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearnServiceImpl implements ILearnService {
    @Autowired
    ILearnDao learnDao;
    @Override
    public int add(LearnResouce learnResouce) {
        return this.learnDao.add(learnResouce);
    }

    @Override
    public int update(LearnResouce learnResouce) {
        return this.learnDao.update(learnResouce);
    }

    @Override
    public int deleteByIds(String ids) {
        return this.learnDao.deleteByIds(ids);
    }

    @Override
    public LearnResouce queryLearnResouceById(Long id) {
        return this.learnDao.queryLearnResouceById(id);
    }


    public PageBean<LearnResouce> queryLearnResouceList(LearnResouce learnResouceQuery, Integer curPage, Integer pageSize){
        PageBean<LearnResouce> page = null;
        String sqlStr = "select * from learn_resource where 1=1 ";
        String whereStr = "";
        if(null!=learnResouceQuery){
            if(null!=learnResouceQuery.getId()){
                whereStr += " and id = " + learnResouceQuery.getId();
            }
            if(StringUtils.isNotBlank(learnResouceQuery.getTitle())){
                whereStr += " and title = '"+learnResouceQuery.getTitle()+"' ";
            }
            if(StringUtils.isNotBlank(learnResouceQuery.getUrl())){
                whereStr += " and url = '"+learnResouceQuery.getUrl()+"'";
            }
            if(StringUtils.isNotBlank(learnResouceQuery.getAuthor())){
                whereStr += " and author = '"+learnResouceQuery.getAuthor()+"'";
            }
        }
        String sqlCountStr = "select count(1) from learn_resource where 1=1 ";
        sqlCountStr += whereStr;
        int total = this.learnDao.selectCount(sqlCountStr);
        if(total>0){
            int totalPage = total%pageSize==0?total/pageSize:total/pageSize+1;
            if(curPage>totalPage){
                curPage = totalPage;
            }
            if(curPage<=0){
                curPage = 1;
            }
            sqlStr += whereStr;

            sqlStr += " order by id limit "+(curPage-1)*pageSize+","+pageSize;
            System.out.println("sql="+sqlStr);
            List<LearnResouce> list = this.learnDao.queryLearnResouceList(sqlStr);
            if(null!=list&&!list.isEmpty()){
                page = new PageBean<LearnResouce>();
                page.setList(list);
                page.setPageSize(pageSize);
                page.setTotalCount(total);
                page.setCurrentPage(curPage);
                page.setTotalPage(totalPage);
            }
        }
        return page;
    }
}
