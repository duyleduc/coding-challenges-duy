package com.elsa.quiz.quizservices.services;


import com.elsa.quiz.ws.JoinQuizRequest;

public interface QuizServiceListener {
    void listen(JoinQuizRequest request);
}
