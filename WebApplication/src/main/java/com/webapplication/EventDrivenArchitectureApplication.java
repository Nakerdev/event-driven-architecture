package com.webapplication;

import com.webapplication.pages.home.HomeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan()
public class EventDrivenArchitectureApplication {
    public static void main(final String[] args) {
        SpringApplication.run(EventDrivenArchitectureApplication.class, args);
    }
}
