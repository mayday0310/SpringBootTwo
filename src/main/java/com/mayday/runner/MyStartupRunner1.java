package com.mayday.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *程序启动的时候去执行加载一些数据
 */
@Component
@Order(1)
public class MyStartupRunner1 implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
         System.out.println("程序启动，开始加载数据..1 ");
    }
}
