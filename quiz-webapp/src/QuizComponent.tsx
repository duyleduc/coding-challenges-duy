import React, { useEffect, useState } from 'react';
import SockJS from 'sockjs-client';
import Stomp, { Client, Frame } from 'stompjs';

interface JoinQuizResponse {
    userId: string;
    quizSessionId: string;
    canJoin: boolean;
    participants: string[];
}

const QuizComponent: React.FC = () => {
    const [userId, setUserId] = useState<string>('');
    const [quizSessionId, setQuizSessionId] = useState<string>('');
    const [response, setResponse] = useState<string | null>(null);
    const [participants, setParticipants] = useState<string[]>([])
    const [stompClient, setStompClient] = useState<Client | null>(null);
    const [connected, setConnected] = useState<boolean>(false);

    useEffect(() => {
        if (!stompClient && !connected) {
            joinWs();
        }
    })

    const joinWs = (callback?: any) => {
        setConnected(true);
        const socket = new SockJS('http://localhost:8080/ws');
        const client = Stomp.over(socket);
        setStompClient(client);
        client.connect({}, (frame: Frame | undefined) => {
            console.log('Connected: ');
            if (callback) {
                callback();
            }
        });
    }


    const sendJoinRequest = () => {
        console.log('sendJoinrequest');
        if (quizSessionId && stompClient) {
            if (connected) {
                join();
            }
        }
    };

    const join = () => {
        if (stompClient) {
            stompClient.send("/app/joinQuiz", {}, JSON.stringify({ 'userId': userId, 'quizSessionId': quizSessionId }));
            const sub = stompClient.subscribe(`/topic/join_quiz_session_response/${quizSessionId}`, (message) => {
                const response: JoinQuizResponse = JSON.parse(message.body);

                setResponse(response.canJoin ? "You can join the quiz session" : "You cannot join the quiz session");
                setParticipants(response.participants);

                if (!response.canJoin) {
                    sub.unsubscribe();
                }
            });
        }
    }

    return (
        <div>
            <h2>Quiz Join Request</h2>
            <div>
                <label>User ID:</label>
                <input type="text" value={userId} onChange={(e) => setUserId(e.target.value)} />
            </div>
            <div>
                <label>Quiz Session ID:</label>
                <input type="text" value={quizSessionId} onChange={(e) => setQuizSessionId(e.target.value)} />
            </div>
            <button onClick={sendJoinRequest}>Join Quiz</button>
            {response && <div>{response}</div>}
            {participants.length > 0 && (
                <div>
                    <h3>Participants</h3>
                    <ul>
                        {participants.map((participant) => (
                            <li key={participant}>{participant}</li>
                        ))}
                    </ul>
                </div>
            )}
        </div>
    );
};

export default QuizComponent;
