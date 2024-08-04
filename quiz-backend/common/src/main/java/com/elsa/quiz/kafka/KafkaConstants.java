package com.elsa.quiz.kafka;

public class KafkaConstants {
    // Topics
    public static String JOIN_QUIZ_SESSION_REQUEST_TOPIC = "request_join_quiz_session";
    public static String JOIN_QUIZ_SESSION_RESPONSE_TOPIC = "response_join_quiz_session";

    // Groups
    public static String QUIZ_SERVICES_GROUP = "quiz_services";
    public static String WEBSOCKET_GROUP ="websocket";
}
