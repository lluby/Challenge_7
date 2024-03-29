package com.example.Challenge7.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    public void addViewController(ViewControllerRegistry registry){
        registry.addRedirectViewController("/", "/swagger-ui/index.html");
    }
}

