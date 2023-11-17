package com.example.Challenge7.controller;

import com.example.Challenge7.model.Order;
import com.example.Challenge7.model.Product;
import com.example.Challenge7.service.OrderService;
import com.example.Challenge7.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/thread")
public class ThreadController {
   @Autowired
   ProductService productService;

   @Autowired
   OrderService orderService;


    @GetMapping(value = "/multi-thread")
    public ResponseEntity getMultiThread() {
        Thread thread1 = new Thread(() -> {
            log.info("Starting thread 1 : " + Thread.currentThread().getName());
            for(int i = 1; i <= 5; i++) {
                System.out.println("Content : "+i);
                if(i == 3) {
                    try {
                        Thread.sleep(5000l);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            log.info("Starting thread 2 : {}", Thread.currentThread().getName());
            for(int i = 10; i >= 4; i--) {
                System.out.println("Content : "+i);
                if(i == 97) {
                    try {
                        Thread.sleep(3000l);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thread1.start();
        try {
            thread1.join(1000l);
            thread1.interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread2.start();
        return ResponseEntity.ok("oke");
    }

    @GetMapping(value = "/race-condition")
    public ResponseEntity getRaceCondition() {
        List<Product> products = productService.getAllProduct();
        System.out.println(productService.getProductDetails(products.get(0).getProductCode()).getProductName());
        return ResponseEntity.ok("ok");
    }

    @GetMapping(value ="/race-condition1")
    public ResponseEntity getRaceCondition1(){
        List<Order> orders = orderService.getAllOrder();
        System.out.println(orderService.getOrderDetails(orders.get(0).getOrderId()).getOrderTime());
        return ResponseEntity.ok("ok");
    }

}
