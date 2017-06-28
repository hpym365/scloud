package com.senyint.feign.ctrl;

import com.senyint.feign.client.ClientApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-6-24 上午7:19
 */
@RestController
public class FeignController {

    @Autowired
    ClientApp clientApp;

    @RequestMapping("/test")
    public String invokeClientAppTest(@RequestParam(required = false) String a){
        String test = clientApp.test(a);
        return test;
    }

    @RequestMapping("/bcz")
    public String bcz(@RequestParam(required = false) String a){
        long l = System.currentTimeMillis();
        String bcz = clientApp.bcz(a);
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
        return bcz;
    }
}
