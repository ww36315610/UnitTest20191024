package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.spring"})
public class SpringBootRunner4 {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRunner4.class, args);
    }
}
