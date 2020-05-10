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

//声明这个类是一个配置类，在类中的方法可以使用@Bean返回一个对象，将对象自动加载到ioc容器中
@Configuration
//判断类加载路径中是否包含API的依赖，ItheimaApi类
@ConditionalOnClass(ItheimaApi.class)
public class TestAutoConfiguration {

    //@Bean可以将方法返回的对象注入到Spring容器中，但是受限于conditional注解
    @Bean
    //判断接口的实现类是否在容器中，如果存在，不创建。如果不存在，则创建
    @ConditionalOnMissingBean(ItheimaApi.class)
    //ConditionalOnProperty作用是根据配置来判断 name属性代表配置项 havingValue指定值
    //if(itcast.framework == "a") return true; else return false matchIfMissing指没有配置时的默认值  true
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
