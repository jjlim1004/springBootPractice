package com.example.bootWeb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@MapperScan(value = "com.example.bootWeb")
//mybatis 사용을 하기 위해 자동 환경설정에서 제외
//@EnableAutoConfiguration(exclude = { DataSourceTransactionManagerAutoConfiguration.class,
//        DataSourceAutoConfiguration.class })
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}