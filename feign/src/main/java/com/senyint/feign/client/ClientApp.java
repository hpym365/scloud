package com.senyint.feign.client;

import com.senyint.feign.hystrix.ClientHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-6-24 上午4:43
 */
@FeignClient(value = "client-app" ,fallback = ClientHystrix.class)
public interface ClientApp {

    // FeignClient这里的参数必须指定value 否则会报错
    @RequestMapping("/test")
    String test(@RequestParam(value = "a",required = false) String a);//@RequestParam(required = false) String a

    @RequestMapping("/timeout")
    String bcz(@RequestParam(value = "a",required = false) String a);//@RequestParam(required = false) String a
}
