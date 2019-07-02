package com.gaoxiong.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaoxiong
 * @ClassName OrderController
 * @Description TODO
 * @date 2019/7/2 0002 下午 10:03
 */
@RestController
@RequestMapping("/api")
public class OrderController {

    @GetMapping("/order")
    public ResponseEntity getOrder(){
        Order order = new Order(2, "gaoxiong", "chuanshan");
        return ResponseEntity.ok(order);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class Order{
        private Integer id;
        private String order_name;
        private String address;
    }
}
