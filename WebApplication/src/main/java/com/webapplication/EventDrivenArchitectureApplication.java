package com.webapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.webApplication.pages",
        "com.webApplication.controllers",
        "domain.modules"})
public class EventDrivenArchitectureApplication {
    public static void main(final String[] args) {
        SpringApplication.run(EventDrivenArchitectureApplication.class, args);
    }
}
