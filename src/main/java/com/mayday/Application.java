package com.mayday;

import com.mayday.config.MyConfigProperties;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;
import java.util.Map;

/**
 * SpringBoot启动类
 */

@SpringBootApplication  //这个注解包含了
@ServletComponentScan
@EnableConfigurationProperties({MyConfigProperties.class})
public class Application {

    //SpringBoot启动类
   public static void main(String [] args){
       SpringApplication.run(Application.class,args);


   }

    //上传文件限制
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();

        //设置文件大小限制 ,超了，页面会抛出异常信息，这时候就需要进行异常信息的处理了;
        //如果上传文件过大，那么会报异常


            factory.setMaxFileSize("256kb"); //KB,MB
            // 设置总上传数据总大小
            factory.setMaxRequestSize("50MB");


        //Sets the directory location where files will be stored.
        //factory.setLocation("路径地址");
        return factory.createMultipartConfig();
    }




}
