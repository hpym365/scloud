package com.senyint.zuul.filter;

import com.senyint.zuul.security.interceptor.SecurityInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping;
import org.springframework.context.annotation.Configuration;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-6-27 下午1:48
 */
@Configuration
public class ZuulHandlerBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    private SecurityInterceptor myInterceptor = new SecurityInterceptor();

    @Override
    public boolean postProcessAfterInstantiation(final Object bean, final String beanName) throws BeansException {
        if (bean instanceof ZuulHandlerMapping) {
            ZuulHandlerMapping zuulHandlerMapping = (ZuulHandlerMapping) bean;
            Object[] objects = {myInterceptor};
            zuulHandlerMapping.setInterceptors(objects);
        }
        return super.postProcessAfterInstantiation(bean, beanName);
    }
}