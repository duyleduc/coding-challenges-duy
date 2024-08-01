## Components description

**Client App (Web/Mobile)**: Users interact with the application through web or mobile.  
**Authentication service**: Handles user registration, login, authentication, and authorization. Ensures secure access to the quiz sessions.   
**CDN (Content Delivery Network)**: Delivers static content like HTML, CSS, JS. Reduces load on the main servers and improves load times for users.  
**API Gateway**: Manages all client requests (handles authentication, request validating, routing, ...).  
**Load balancer**: Distributes incoming traffic across multiple instances of backend services -- ensures high availability and reliability.  
**Websocket server**: Manages real time communication with clients. Mantains *Websocket* connections for live updates.  
**Quiz service**: Handles the core quiz logic, such as serving questions, creating questions, quiz and also managing quiz session.   
**Score service**: Receives user answers from the Quiz Service., calculates and updates scores based on user responses.  
**Leaderboard service**: Mantains and serves the leaderboard, showing the current standings of participants. Publishes leaderboard updates to the Message Broker.  
**Timer service**: Manages timers for each quiz question. Ensures every participants acces to the same question of a quiz session at instant T.  
**Message broker**: Kafka - Manages the message queue for timer events and other real-time data streams.  
**Cache service**: Redis - Acts as a fast, in-memory data store for session states and timer information, ensuring quick access and persistence.  
**Database**: Stores persistent data, such as user information, quiz questions, and results.

**Error tracking**: Ensures error tracking in order to facilitate debugging. Easier access to bug log.  
**Logging**: Centralizes and aggregates logs from services(http logs, services logs and applicatifs logs). Acceses to logs for everyone.  
**Server monitoring**: Monitors services health. Helps to reacts quicker to incidents.

---
## Data flow

1. **User Joins a Quiz:**

- The user connects via the Client App.  
- The request passes through the CDN (for static assets) and then the API Gateway.
- The API Gateway routes the request to the WebSocket server.
- The WebSocket server establishes a persistent connection with the client.
- The WebSocket server sends a message to the Message Broker to notify about the new participant.
- The Quiz Service updates the list of participants, quiz session state, and the database. It then sends an event to the Message Broker indicating that a new participant has joined.
- The WebSocket server consumes this event from the Message Broker and sends notifications to all connected clients about the new participant.
- The Client(s) must update interface when receives data from the Websocket server

2. **Quiz Starts:**

- Once there are enough participants, the Quiz Service sends a message to the Message Broker, indicating that the quiz will start in X seconds.
- The WebSocket Server consumes this message and sends a notification to all connected clients about the upcoming start time.
- The Timer Service consumes the message from the Message Broker and schedules the next execution to send the first question via the Message Broker.

3. **Send Questions:**

- The Timer Service sends a message with information about the execution (e.g., the next question) to the Message Broker.
- The Quiz Service receives this message from the Message Broker and sends the question to the Message Broker again.
- The Quiz Service updates the database with the current quiz session state.
- The WebSocket Server receives the message from the Message Broker and sends the question to all connected clients.
- The Timer Service receives a confirmation message (if any) and schedules the next execution to send subsequent questions via the Message Broker.

4. **User Submits an Answer:**

- The client sends the answer via the WebSocket server.
- The WebSocket Server forwards the answer to the Quiz Service.
- The Quiz Service validates the answer and publishes the result to a Kafka topic.

5. **Score Calculation:**

- The Score Service consumes the answer messages from the Kafka topic.
- The Score Service calculates the score and publishes the updated scores to another Kafka topic.

6. **Leaderboard Update:**

- The Leaderboard Service consumes the updated scores from the Kafka topic.
- The Leaderboard Service updates the leaderboard in the database.
- The updated leaderboard is sent to the WebSocket server.
- The WebSocket server broadcasts the updated leaderboard to all connected clients.

---
There are also others sides cases we must manage:

1. **When the timer of a question is ended**
- The scheduled message on Timer serivce sends message to Websocket server with the second question data.  
- The Websocket server send the second question to all participants.  


2. **When user comes back after an interruption**
- When a user comes back the quiz session after an interruption (assummed network). The process should start with step (1) and add some checks:
    - if user is already in the session via Quiz service 
    - send the correct question based on data inside database. 


---
## Technology  
**Clients**:
- Mobile: depends on team's skills, choose the best technogy that we master and should be up to date. Some suggestions: Flutter/Android,iOS native (Kotlin/Swift), they are modern technology.
- Web: depends on team's skills also, choose the best technology that we master and should be up to date. Some suggestions: Angular, ReactJS or VueJS. 

**Backend**: 
- Backend language as Java, Python, NodeJS, ... with built in Framework like Spring Boot (java), Django/Flask(Python) or Express
- Websocket server: Use socket.io (NodeJS) or Spring websocket (Java).  
- Kafka: Ensures real-time updates are broadcast to all connected clients. Kafka is the best solution for HA and Scalibility. Kafka also offers the message ordering and guarantees.  
- Cache: Use redis as simple to install and usage.  
- API Gateway: use cloud service on aws/gcp/azure (if hosting) else kong or nginx for self hosted.  
- Load Balancer: use cloud service on aws/gcp/azure (AWS ELB) (if hosting) else nginx, traefik.  
- CDN: Cloudflare, AWS CloudFront, ...  

**Database**
- PostgreSQL: suitable to store different type of data. For quiz data, jsonb could handle well data structure. Future functionnality is easier to be adapted in PG.

**Packaging**
- 

**Hosting**
- This application is built for a future with a lot of users, so it's better to deploy application to a public cloud, suggestion AWS, which provides scalable infrastructure with managed services, reducing operational overhead. The cost (labor and services) maybe better than GCP or Azure.

**Monitoring**

**Error tracking**
- Sentry is a good choice to handle error tracking in client (mobile or web app) and also on backend side. User friendly and easy to integrate.
- Logging: ELK stack to centralize and aggregate logs from differents components. Helps developpers to have a trace of log.
- Server monitoring: Should monitor servers. Could integrate with Prometheus (exporters), Grafana to visualize and AlertManager to receive alerts on infrastructure.  
