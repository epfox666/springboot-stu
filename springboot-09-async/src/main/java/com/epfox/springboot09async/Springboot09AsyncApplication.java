package com.epfox.springboot09async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling //开启定时任务功能
@EnableAsync //开启异步注解功能
@SpringBootApplication
public class Springboot09AsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot09AsyncApplication.class, args);
    }

}
