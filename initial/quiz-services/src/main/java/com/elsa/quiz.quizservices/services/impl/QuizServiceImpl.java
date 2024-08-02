package com.elsa.quiz.quizservices.services.impl;

import com.elsa.quiz.quizservices.dto.UserJoinQuizRequestDTO;
import com.elsa.quiz.quizservices.dto.UserJoinQuizResponseDTO;
import com.elsa.quiz.quizservices.services.QuizService;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepositories quizRepositories;
    @Override
    public UserJoinQuizResponseDTO joinQuiz(UserJoinQuizRequestDTO joinQuizRequest) {
        return null;
    }
}
