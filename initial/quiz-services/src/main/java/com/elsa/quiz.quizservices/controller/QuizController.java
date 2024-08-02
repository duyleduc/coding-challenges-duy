package com.elsa.quiz.quizservices.controller;

import com.elsa.quiz.quizservices.dto.UserJoinQuizRequestDTO;
import com.elsa.quiz.quizservices.dto.UserJoinQuizResponseDTO;
import com.elsa.quiz.quizservices.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Receive REST API for quiz
 */
@RestController(value = "/api/v1/quiz")
public class QuizController {

    @Autowired
    private final QuizService quizService;

    @PostMapping("/join")
    public UserJoinQuizResponseDTO joinQuiz(@RequestBody UserJoinQuizRequestDTO joinQuizRequest) {

    }

}
