package com.elsa.quiz.websocketserver.controller;

import com.elsa.quiz.websocketserver.kafka.KafkaConstants;
import com.elsa.quiz.ws.JoinQuizRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

/**
 * Quiz controller for websocket
 */
@Controller
public class QuizController {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    private Logger logger = LogManager.getLogger(QuizController.class);

    @MessageMapping("/joinQuiz")
    public void joinQuiz(@Payload JoinQuizRequest joinQuizRequest) {
        logger.info("Receive join quiz with info, quizSesisonId " + joinQuizRequest.getQuizSessionId() + " userId " + joinQuizRequest.getUserId());
        kafkaTemplate.send(KafkaConstants.JOIN_QUIZ_SESSION_REQUEST_TOPIC, joinQuizRequest);
    }
}
