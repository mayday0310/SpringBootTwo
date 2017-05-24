package com.mayday.listener;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * HttpSession监听器 ，主要实现了HttpSessionListener接口
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener{
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("session被创建 ..");

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("session被销毁 .. ");
    }
}
