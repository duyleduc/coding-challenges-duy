package com.elsa.quiz.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name = "quiz_session")
@Data
public class QuizSession {
    private UUID id;
    @ManyToOne()
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
    @ManyToMany()
    private Set<User> participants = new HashSet<>();
}
