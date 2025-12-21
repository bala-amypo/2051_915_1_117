package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Main Spring Boot Application class
 */
@SpringBootApplication
@ServletComponentScan(basePackages = "com.example.demo.servlet") // Scans for @WebServlet
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
