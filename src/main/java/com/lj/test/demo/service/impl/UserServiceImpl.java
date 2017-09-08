package com.lj.test.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lj.test.demo.dao.UserMapper;
import com.lj.test.demo.model.User;
import com.lj.test.demo.service.IUserService;
import com.lj.test.demo.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {
    private static final String PAGE_KEY = "page";
    private static final String PAGE_SIZE_KEY = "pageSize";

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return this.addUser(user);
    }

    @Override
    public int updateUser(User user) {
        return this.updateUser(user);
    }

    @Override
    public int deleteByIds(String[] ids) {
        return this.userMapper.deleteByIds(ids);
    }

    @Override
    public User queryUserById(Long id) {
        return this.userMapper.queryUserById(id);
    }

    @Override
    public List<User> queryUserList(Map<String, Object> params) {
        PageHelper.startPage(Integer.parseInt(params.get("page").toString()), Integer.parseInt(params.get("pageSize").toString()));
        return this.userMapper.queryUserList(params);
    }

    @Override
    public PageInfo<User> pageList(Map<String, Object> params) {
        Integer page = 1,pageSize = 10;
        if(null==params || params.isEmpty()){
            page = params.get(PAGE_KEY)!=null?Integer.parseInt(params.get(PAGE_KEY).toString()):page;
            pageSize = params.get(PAGE_SIZE_KEY)!=null?Integer.parseInt(params.get(PAGE_SIZE_KEY).toString()):pageSize;
        }
        PageHelper.startPage(page, pageSize);
        List<User> userList = this.userMapper.queryUserList(params);
        PageInfo<User> pageList = new PageInfo<User>(userList);

        return pageList;
    }
}
