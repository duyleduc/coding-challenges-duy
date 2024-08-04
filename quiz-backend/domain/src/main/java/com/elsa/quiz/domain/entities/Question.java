package com.elsa.quiz.domain.entities;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name = "question")
@Data
public class Question {
    private UUID id;
    private String question;

    private Set<Answer> answers = new HashSet<>();
}