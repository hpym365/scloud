package com.senyint.feign.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.strategy.properties.HystrixPropertiesCommandDefault;
import com.netflix.hystrix.strategy.properties.HystrixPropertiesStrategy;
import com.netflix.hystrix.strategy.properties.HystrixPropertiesStrategyDefault;
import org.springframework.context.annotation.Configuration;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-6-25 上午5:25
 */
@Configuration
public class HystrixConfig  {


    public HystrixCommand getConfig(){

        return new HystrixCommandInstance();
    }

    class HystrixCommandInstance extends HystrixCommand{

        public HystrixCommandInstance() {
            super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"), 500);
        }

        @Override
        protected Object run() throws Exception {
            return null;
        }
    }
}
