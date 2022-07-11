package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController
{
    private static String url = "http://localhost:8001";
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
}
