package com.yang.springcloud.controller;

import com.yang.springcloud.base.entity.Payment;
import com.yang.springcloud.base.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE-DEV";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);  //写操作
    }

    @PostMapping("/consumer/payment/getPayment")
    public CommonResult getPayment(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/getPaymentById",payment,CommonResult.class);
    }

}
