package com.mayday.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 自定义过滤器
 * filterName 过滤器名称
 * urlPatterns 过滤的路径
 */
@WebFilter(filterName = "MyFilter",urlPatterns ="/*" )
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      System.out.println("过滤器初始化.. ");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
           System.out.println("执行过滤操作 ");
           filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
      System.out.println("过滤器被销毁..");
    }
}
