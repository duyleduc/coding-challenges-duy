package com.elsa.quiz.ws;

import java.io.Serializable;

public class JoinQuizRequest implements Serializable {
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
