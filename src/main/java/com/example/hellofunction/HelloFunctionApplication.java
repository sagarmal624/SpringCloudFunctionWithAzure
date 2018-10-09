package com.example.hellofunction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class HelloFunctionApplication {

    @Bean
    public Function<String, String> hello() {
        return s -> "Hello " + s + "!";
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloFunctionApplication.class, args);
    }
}
