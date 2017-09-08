package com.lj.test.demo;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.lj.test.demo.model.User;
import com.lj.test.demo.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@WebAppConfiguration
public class UserServiceTest {
    @Autowired
    private IUserService userService;

    @Test
    public void queryTest(){
        Long id = 1L;
        User user = userService.queryUserById(id);
        System.out.println("user:"+ JSON.toJSONString(user));

        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("page",1);
        paramMap.put("pageSize",1);
        List<User> userList = userService.queryUserList(paramMap);
        System.out.println("userList:"+ JSON.toJSONString(userList));

        PageInfo<User> pageList = userService.pageList(paramMap);
        System.out.println("pageList:"+ JSON.toJSONString(pageList));
    }
}
