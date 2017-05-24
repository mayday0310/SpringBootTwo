package com.mayday.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 获取配置文件中的参数信息
 */
@ConfigurationProperties(prefix ="spring.datasource")
public class MyConfigProperties {

    private String url;
    private String username;
    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
