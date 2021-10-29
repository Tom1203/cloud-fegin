package com.itheima.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;


public class DefaultFeignConfiguration {
    @Bean
    public Logger.Level feignLogger(){
        return Logger.Level.BASIC;
    }
}
