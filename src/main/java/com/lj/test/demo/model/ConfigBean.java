package com.lj.test.demo.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.tongtong")
public class ConfigBean {
    private String name;
    private String want;

    public void setName(String name) {
        this.name = name;
    }

    public void setWant(String want) {
        this.want = want;
    }

    public String getName() {
        return name;
    }

    public String getWant() {
        return want;
    }
}
