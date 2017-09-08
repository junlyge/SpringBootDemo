package com.lj.test.demo;

import com.lj.test.demo.model.LearnResouce;
import com.lj.test.demo.service.ILearnService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@WebAppConfiguration
public class LearnServiceTest {
    @Autowired
    private ILearnService learnService;

    @Test
    public void xx(){
        LearnResouce learnResouce = new LearnResouce();
        learnResouce.setTitle("这是一个测试3");
        learnResouce.setAuthor("test3");
        learnResouce.setUrl("http://test3.com");
        learnService.add(learnResouce);
    }
}
