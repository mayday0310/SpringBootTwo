package com.mayday.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 程序启动的时候去执行加载一些数据
 * 实现ApplicationRunner接口也可以 或者实现CommandLineRunner接口
 */
@Component
@Order(2)
public class MyStartupRunner2 implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println("程序启动，开始加载数据..2");
    }


}
