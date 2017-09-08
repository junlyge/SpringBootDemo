package com.lj.test.demo.dao;

import com.lj.test.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    int add(User user);
    int update(User user);
    int deleteByIds(String[] ids);
    User queryUserById(Long id);
    List<User> queryUserList(Map<String, Object> params);
}
