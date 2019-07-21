package com.brianxia.testspringbootautoconfig;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class TestTemplate implements ApplicationRunner {
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("我被加载啦");
    }

    public String getTest(){
        return "我能被调用啦";
    }
}
