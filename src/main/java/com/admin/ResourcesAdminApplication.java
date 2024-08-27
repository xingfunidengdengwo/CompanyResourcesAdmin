package com.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ResourcesAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResourcesAdminApplication.class, args);
    }
}
