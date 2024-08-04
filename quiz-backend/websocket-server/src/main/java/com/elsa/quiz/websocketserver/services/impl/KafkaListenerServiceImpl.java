package com.elsa.quiz.websocketserver.services.impl;

import com.elsa.quiz.websocketserver.services.KafkaListenerService;
import com.elsa.quiz.ws.JoinQuizResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerServiceImpl implements KafkaListenerService {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    private Logger logger = LogManager.getLogger(KafkaListenerServiceImpl.class);

    @KafkaListener(topics = "response_join_quiz_session", groupId = "webSocketGroup")
    public void joinQuizSessionResponse(JoinQuizResponse response) {
        logger.info("Receive response of request join quiz session " + response.getQuizSessionId() + " canJoin: " + response.isCanJoin());
        simpMessagingTemplate.convertAndSend("/topic/join_quiz_session_response/" + response.getQuizSessionId(), response);
    }
}
