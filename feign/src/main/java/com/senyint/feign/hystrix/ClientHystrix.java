package com.senyint.feign.hystrix;

import com.senyint.feign.client.ClientApp;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-6-25 上午2:57
 */
@Component
public class ClientHystrix implements ClientApp{
    @Override
    public String test(@RequestParam(value = "a",required = false) String a) {
        return "当前服务不可用,一会再试试吧O(∩_∩)O";
    }

    @Override
    public String bcz(String a) {
        return "访问了一个不存在的服务";
    }
}
