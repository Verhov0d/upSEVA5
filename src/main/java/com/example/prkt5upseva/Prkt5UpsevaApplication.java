package com.example.prkt5upseva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude = { SecurityAutoConfiguration.class })
public class Prkt5UpsevaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Prkt5UpsevaApplication.class, args);
    }

}
