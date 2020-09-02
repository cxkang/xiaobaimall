package com.xiaobai.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class XiaobaiUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaobaiUserApplication.class, args);
    }

}
