package com.brianxia.testspringbootautoconfig;

import com.brianxia.itcast.a.AlphaTemplate;
import com.brianxia.springbootitheima.api.ItheimaApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestEasyConfiguration {

    @Bean
    public EasyApi getApi(){
        System.out.println("TestEasyConfiguration被加载了");
        return new EasyApiImpl();
    }
}
