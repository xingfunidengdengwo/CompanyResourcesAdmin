package com.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {
    public static final String STATIC_PATH="/img/";
    public static final String STATIC_DRI="D:\\uploadfile\\";
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(STATIC_PATH+"**").addResourceLocations("file:"+STATIC_DRI);
    }
}
