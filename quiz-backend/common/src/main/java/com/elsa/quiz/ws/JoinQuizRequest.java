package com.elsa.quiz.ws;

public class JoinQuizRequest {
    private String quizSessionId;
    private String userId;

    public String getQuizSessionId() {
        return quizSessionId;
    }

    public void setQuizSessionId(String quizSessionId) {
        this.quizSessionId = quizSessionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
