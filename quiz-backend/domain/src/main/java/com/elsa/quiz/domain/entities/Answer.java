package com.elsa.quiz.domain.entities;


import jakarta.persistence.Entity;
import lombok.Data;

import java.util.UUID;

@Entity(name = "answer")
@Data
public class Answer {
    private UUID id;
}