package com.lj.test.demo.service;

import com.github.pagehelper.PageInfo;
import com.lj.test.demo.model.User;

import java.util.List;
import java.util.Map;

public interface IUserService {
    public int addUser(User user);
    public int updateUser(User user);
    public int deleteByIds(String[] ids);
    public User queryUserById(Long id);
    public List<User> queryUserList(Map<String, Object> params);
    public PageInfo<User> pageList(Map<String, Object> params);
}
