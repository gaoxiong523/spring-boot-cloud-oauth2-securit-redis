package com.gaoxiong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author gaoxiong
 * @ClassName AuthServerApp
 * @Description 授权服务中心
 * @date 2019/6/24 15:58
 */
@SpringBootApplication
@EnableResourceServer
@EnableDiscoveryClient
public class AuthServerApp {
    public static void main ( String[] args ) {
        SpringApplication.run(AuthServerApp.class, args);
    }
}
