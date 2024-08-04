package com.elsa.quiz.websocketserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfiguration
public class WebsocketServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebsocketServerApplication.class, args);
    }
}