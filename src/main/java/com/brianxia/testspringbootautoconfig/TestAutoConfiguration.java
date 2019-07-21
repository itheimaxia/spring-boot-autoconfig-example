package com.brianxia.testspringbootautoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(TestTemplate.class)
public class TestAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean(TestTemplate.class)
    public TestTemplate greetingApplicationRunner() {
        System.out.println("自动装配加载啦！");
        return new TestTemplate();
    }
}
