package com.mayday.environment;

import com.mayday.config.MyConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * 程序在启动的时候获取配置信息
 * 需要申明Configutation注解和实现EnvironmentAware接口
 */
@Configuration
public class MyEnvironmentAware implements EnvironmentAware {

    //注入application.properties的属性到指定变量中.
    @Value("${spring.datasource.url}")
    private String  Myurl;




    //注意重写的方法 setEnvironment 是在系统启动的时候被执行。
    @Override
    public void setEnvironment(Environment environment) {

         System.out.println("启动程序时，加载的系统属性为:"+Myurl);

         System.out.println("Java_HOME"+environment.getProperty("JAVA_HOME"));




        //获取到前缀是"spring.datasource." 的属性列表值.
        RelaxedPropertyResolver relaxedPropertyResolver = new RelaxedPropertyResolver(environment, "spring.datasource.");
        System.out.println("spring.datasource.url="+relaxedPropertyResolver.getProperty("url"));

    }
}
