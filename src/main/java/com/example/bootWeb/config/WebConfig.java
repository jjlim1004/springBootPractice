package com.example.bootWeb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//cors 허용 관련
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8000","http://127.0.0.1:8000","http://192.168.0.31:8000")
                .allowedMethods("*");//.allowedMethods("GET","POST");
    }
}
