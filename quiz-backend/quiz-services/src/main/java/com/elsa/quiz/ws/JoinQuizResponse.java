package com.elsa.quiz.ws;


import java.io.Serializable;
import java.util.List;

public class JoinQuizResponse implements Serializable {
    private String userId;
    private String quizSessionId;
    private boolean canJoin;
    private List<String> participants;

    public JoinQuizResponse() {
    }

    public JoinQuizResponse(String userId, String quizSessionId, boolean canJoin, List<String> participants) {
        this.userId = userId;
        this.quizSessionId = quizSessionId;
        this.canJoin = canJoin;
        this.participants = participants;
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

    public List<String> getParticipants() {return this.participants;}

    public void setParticipants(List<String> participants) {this.participants = participants;}
}
