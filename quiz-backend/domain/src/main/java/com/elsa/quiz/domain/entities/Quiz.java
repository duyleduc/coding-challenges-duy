package com.elsa.quiz.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name = "quiz")
@Data
public class Quiz {
    private UUID id;
    private String description;
    @OneToMany(mappedBy = "quiz")
    private Set<QuizSession> sessions = new HashSet<>();
}