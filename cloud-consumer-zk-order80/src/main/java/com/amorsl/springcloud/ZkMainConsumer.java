package com.amorsl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZkMainConsumer {
    public static void main(String[] args) {
        SpringApplication.run(ZkMainConsumer.class,args);
    }
}
