package com.demo;

import java.sql.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;


@Configuration
@SpringBootApplication
public class DemoApplication {//这是启动类;要将Application类放在最外侧,即包含所有子包

    //原因:spring-boot会自动加载启动类所在包下及其子包下的所有组件.
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);//不能启动的原因可能是忘记打开数据库，则连接不上

    }

    /**
     * 文件上传配置
     *
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大
        factory.setMaxFileSize("10240MB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("102400MB");
        return factory.createMultipartConfig();
    }
}

