package com.elsa.quiz.domain.entities;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name = "users")
@Data
public class User {
    private UUID id;
    private String username;
    private String firstName;
    private String lastName;
    private Set<QuizSession> quizSessions= new HashSet<>();
    // other attributes here
}
