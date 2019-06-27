package com.gaoxiong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author gaoxiong
 * @ClassName OrderServiceApp
 * @Description TODO
 * @date 2019/6/27 14:13
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderServiceApp {
    public static void main ( String[] args ) {
        SpringApplication.run(OrderServiceApp.class, args);
    }
}
