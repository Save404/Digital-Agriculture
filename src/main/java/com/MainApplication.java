package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/*
 * 使用@SpringBootApplication注解标记的类会被SpringBoot进行加载
 * 默认会扫描当前类所在包和子包所有配置了spring注解的所有类
 * 可以通过scanBasePackages设置扫描的包
 */
@ServletComponentScan
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
