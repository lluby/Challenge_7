package com.example.Challenge7.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzScheduler {
    private final ApplicationContext applicationContext;

    @Autowired
    public QuartzScheduler(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

}
