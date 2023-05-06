package com.abdalsalam.spring.towerdata.demo;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.abdalsalam.spring.towerdata.demo.service.MyService;
import com.abdalsalam.spring.towerdata.demo.service.MyServiceImpl;


@Configuration
public class MyConfiguration {

    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
