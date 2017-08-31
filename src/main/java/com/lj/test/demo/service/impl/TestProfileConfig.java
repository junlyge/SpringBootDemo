package com.lj.test.demo.service.impl;

import com.lj.test.demo.service.IProfileConfig;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "test")
public class TestProfileConfig implements IProfileConfig{

    public void configure() {
        System.out.println("test configure");
    }
}
