## 使用方法：
本项目为了演示spring-boot自动配置使用。

直接使用maven对于root的pom进行install即可。
##### mvn install项目顺序：
1.spring-boot-itheima-api  
2.itcast-a-template  
3.itcast-b-template  
4.test-spring-boot-autoconfig  
5.spring-boot-itheima-api

##### spring项目中依赖： 
````
        <dependency>
            <groupId>com.brianxia</groupId>
            <artifactId>spring-boot-starter-itcast</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
````

##### 添加配置文件：

````
itcast.framework=b
````
值是a加载a框架，值是b加载b框架。不添加配置默认加载a框架。
