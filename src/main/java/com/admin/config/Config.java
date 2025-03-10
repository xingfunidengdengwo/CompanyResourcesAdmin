package com.admin.config;

import com.admin.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {
    public static final String STATIC_PATH = "/img/";
    public static final String STATIC_DRI = "D:\\uploadfile\\";

    @Autowired
    LoginInterceptor loginInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(STATIC_PATH + "**").addResourceLocations("file:" + STATIC_DRI);
    }

    //配置拦截器   让拦截器生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/dologin", "/operators", STATIC_PATH + "**", "/sendmsg", "/sendregistermsg", "/updatepassword", "/operatorsimg", "/operatorsimg/**", "/checktoken");
    }
}
