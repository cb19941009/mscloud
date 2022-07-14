package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController
{
    private static String url = "http://cloud-payment-service";
    @Resource
    private RestTemplate restTemplate;

    /**
     * 新增
     * @param payment
     * @return
     */
    @PostMapping("create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        return restTemplate.postForObject(url + "/payment/create",payment,CommonResult.class);
    }
    @GetMapping("get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") String id){
        return restTemplate.getForObject(url + "/payment/get/"+id,CommonResult.class);
    }
}
