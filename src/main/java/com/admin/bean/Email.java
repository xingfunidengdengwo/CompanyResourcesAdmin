package com.admin.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "email")
@Data
public class Email {

    // 发送名称
    private final String name = "公司公共资源管理系统";

    // 发送人
    private String from;
    // 接收人
    private String to;
    // 标题
    private String subject;
    // 正文前缀
    private String contextPrefix;
    // 正文后缀
    private String contextSuffix;
}