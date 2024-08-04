package com.elsa.quiz.quizservices.services.impl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TempService {
    private List<String> participants = new ArrayList<>();

    public void addParticpant(String participant) {this.participants.add(participant);}

    public List<String> retreiveParticipants() {return this.participants;}

}
