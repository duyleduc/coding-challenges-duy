package com.elsa.quiz.quizservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfiguration
public class QuizServicesApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuizServicesApplication.class, args);
    }
}
