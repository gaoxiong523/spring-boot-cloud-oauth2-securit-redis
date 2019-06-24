package com.gaoxiong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author gaoxiong
 * @ClassName EurekaServiceApp
 * @Description TODO
 * @date 2019/6/24 15:45
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceApp {
    public static void main ( String[] args ) {
        SpringApplication.run(EurekaServiceApp.class, args);
    }
}
