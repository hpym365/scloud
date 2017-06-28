package com.senyint.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-6-24 上午4:14
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(HttpServletRequest request,@RequestParam(required = false) String a) {
        int localPort = request.getLocalPort();
        String str = "访问的服务端口号:"+localPort +"  I receive the string is :";
        a = (a == null) ? "input is 啥都没有" : a;
        return str + a;
    }

    @RequestMapping("/timeout")
    public String timeout() throws InterruptedException {
        Long sleep = 10000l;
        Thread.sleep(sleep);
        return "等待:"+sleep;
    }
}
