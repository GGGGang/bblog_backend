package com.example.blog.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * @author zhuqigang
 */
@SpringBootApplication
@EnableWebSecurity
@MapperScan("com.example.blog.demo.mapper")
public class BblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BblogApplication.class, args);
    }

}
