package com.elsa.quiz.quizservices.services.impl;

import com.elsa.quiz.quizservices.kafka.KafkaConstants;
import com.elsa.quiz.quizservices.services.QuizServiceListener;
import com.elsa.quiz.quizservices.services.QuizSessionService;
import com.elsa.quiz.ws.JoinQuizRequest;
import com.elsa.quiz.ws.JoinQuizResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceListenerImpl implements QuizServiceListener {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private QuizSessionService quizSessionService;
    private Logger logger = LogManager.getLogger(QuizServiceListenerImpl.class);


    @KafkaListener(topics = "request_join_quiz_session", groupId = "quizServices")
    @Override
    public void listen(JoinQuizRequest request) {
        // Create a response message
        logger.info("Request join quiz session - consume kafka message " + request.getQuizSessionId());
        JoinQuizResponse response = quizSessionService.canJoinQuizSession(request);

        // Send response to response of session id Kafka topic
        // Consumer of this topic:
        // - Websocket server : send notifications to clients
        // - Score service:
        kafkaTemplate.send(KafkaConstants.JOIN_QUIZ_SESSION_RESPONSE_TOPIC, response);
    }

}
