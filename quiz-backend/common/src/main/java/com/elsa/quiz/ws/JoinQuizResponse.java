package com.elsa.quiz.ws;


public class JoinQuizResponse {
    private String userId;
    private String quizSessionId;
    private boolean canJoin;

    public JoinQuizResponse(String userId, String quizSessionId, boolean canJoin) {
        this.userId = userId;
        this.quizSessionId = quizSessionId;
        this.canJoin = canJoin;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getQuizSessionId() {
        return quizSessionId;
    }

    public void setQuizSessionId(String quizSessionId) {
        this.quizSessionId = quizSessionId;
    }

    public boolean isCanJoin() {
        return canJoin;
    }

    public void setCanJoin(boolean canJoin) {
        this.canJoin = canJoin;
    }
}
