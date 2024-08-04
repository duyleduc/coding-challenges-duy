package com.elsa.quiz.quizservices.services.impl;

import com.elsa.quiz.quizservices.QuizSession;
import com.elsa.quiz.quizservices.services.QuizSessionService;
import com.elsa.quiz.ws.JoinQuizRequest;
import com.elsa.quiz.ws.JoinQuizResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class QuizSessionServiceImpl implements QuizSessionService {
//    @Autowired
//    private QuizSessionRepository quizSessionRepository;

    @Autowired
    private TempService tempService;

    @Override
    public JoinQuizResponse canJoinQuizSession(JoinQuizRequest request) {
        final QuizSession quizSession = getQuizSession(request.getQuizSessionId());
        if (quizSession == null) {
            return new JoinQuizResponse(request.getUserId(), request.getQuizSessionId(), false, new ArrayList<>());
        }

        final boolean canJoinQuiz = canJoin(quizSession, request);
        if (canJoinQuiz) {
            tempService.addParticpant(request.getUserId());
            join(quizSession, request);
            return new JoinQuizResponse(request.getUserId(), request.getQuizSessionId(), canJoinQuiz, tempService.retreiveParticipants());
        }
        return new JoinQuizResponse(request.getUserId(), request.getQuizSessionId(), false, new ArrayList<>());
    }

    private QuizSession getQuizSession(String quizSessionId) {
//        final QuizSession quizSession = quizSessionRepository.findById(request.getQuizSessionId()).orElse(null);

        return new QuizSession();
    }

    // check other logics:
    // - is user in another session which is on going
    // - state of quiz session
    // - number of participants in the session
    private boolean canJoin(QuizSession quizSession, JoinQuizRequest request) {
        // Test purpose only in 2 case can join or not
        return "123".equals(request.getQuizSessionId());
    }

    // Join a quiz session
    // - Update quizsession data
    // - Update user data
    private void join(QuizSession quizSession, JoinQuizRequest request) {

    }
}
