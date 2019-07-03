package com.example.demo.controller;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gaoxiong
 * @ClassName UserController
 * @Description TODO
 * @date 2019/7/1 10:54
 */
@Controller
public class UserController {

    @RequestMapping("/user")
    public String getUser(){
        return "gaoxiong";
    }
}
