package com.elsa.quiz.domain.repositories;

import com.elsa.quiz.domain.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QuizRepositories extends JpaRepository<UUID, Quiz> {
}
