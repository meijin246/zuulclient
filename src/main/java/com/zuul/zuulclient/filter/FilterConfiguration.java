package com.zuul.zuulclient.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {

    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }
}
