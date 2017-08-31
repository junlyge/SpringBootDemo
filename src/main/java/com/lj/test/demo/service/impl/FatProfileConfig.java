package com.lj.test.demo.service.impl;

import com.lj.test.demo.service.IProfileConfig;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value="fat")
public class FatProfileConfig implements IProfileConfig {
    @Override
    public void configure() {
        System.out.println("fat configure");
    }
}
