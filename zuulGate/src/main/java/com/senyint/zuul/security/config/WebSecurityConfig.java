package com.senyint.zuul.security.config;

import com.senyint.zuul.security.interceptor.SecurityInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-6-27 下午12:39
 */
@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("WebSecurityConfig  addInterceptorsaddInterceptorsaddInterceptors");
//        InterceptorRegistration interceptor = registry.addInterceptor(getSecurityInteceptor()).excludePathPatterns("/login**").addPathPatterns("/**");
//        interceptor.excludePathPatterns("/login**");
//        interceptor.addPathPatterns("/**");
//        super.addInterceptors(registry);
        registry.addInterceptor(getSecurityInteceptor()).addPathPatterns("/**").excludePathPatterns("/login");
    }


    @Bean
    public SecurityInterceptor getSecurityInteceptor(){
        return new SecurityInterceptor();
    }
}
