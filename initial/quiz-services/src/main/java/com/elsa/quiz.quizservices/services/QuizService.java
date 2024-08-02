package com.elsa.quiz.quizservices.services;


import com.elsa.quiz.quizservices.dto.UserJoinQuizRequestDTO;
import com.elsa.quiz.quizservices.dto.UserJoinQuizResponseDTO;

public interface QuizService {
    UserJoinQuizResponseDTO joinQuiz(UserJoinQuizRequestDTO joinQuizRequest);
}
