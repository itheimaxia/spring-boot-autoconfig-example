package com.brianxia.testspringbootautoconfig;

import com.brianxia.itcast.a.AlphaTemplate;
import com.brianxia.itcastbtemplate.BetaTemplate;
import com.brianxia.springbootitheima.api.ItheimaApi;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(ItheimaApi.class)
public class TestAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean(ItheimaApi.class)
    //matchIfMissing指没有配置时的默认值
    @ConditionalOnProperty(name = "itcast.framework", havingValue = "a", matchIfMissing = true)
    public ItheimaApi getATemplate() {
        System.out.println("自动装配加载A框架啦！");
        return new AlphaTemplate();
    }

    @Bean
    @ConditionalOnMissingBean(ItheimaApi.class)
    @ConditionalOnProperty(name = "itcast.framework", havingValue = "b")
    public ItheimaApi getBTemplate() {
        System.out.println("自动装配加载B框架啦！");
        return new BetaTemplate();
    }
}
