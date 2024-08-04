package com.elsa.quiz.quizservices.services;

import com.elsa.quiz.ws.JoinQuizRequest;
import com.elsa.quiz.ws.JoinQuizResponse;

public interface QuizSessionService {
    JoinQuizResponse canJoinQuizSession(JoinQuizRequest request);
}
