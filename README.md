# Quiz Application

This project is a real-time quiz application with a WebSocket-based system for handling quiz sessions and participant management. It includes both front-end and back-end components, which are detailed below.

## Overview

### PART_1.md 
The presentation about architecture of the application.
### PART_2.md
The presentation about the future building of the application.

### quiz-backend

The back-end component is a Spring Boot application that handles WebSocket connections and Kafka messaging. It allows users to join quiz sessions and communicates with a Kafka message broker to manage quiz session validation and participant updates.

### quiz-webapp: Front-End

The front-end component is a React application that connects to the WebSocket server, sends requests to join quiz sessions, and displays real-time updates about the quiz session and participants.

## Running the Application
### Infrastructure
Run this command to install infrastructures 
```
docker-compose up -d
```

These applications will start in background:
```
- PostgreSQL latest version
- Kafka 
- Kafka UI on http://localhost:8090
- Zookeeper
```

### Back-End

1. **Install Java 17**

   Make sure Java 17 is installed. You can use SDKMAN! to install it:

   ```sh
   curl -s "https://get.sdkman.io" | bash
   source "$HOME/.sdkman/bin/sdkman-init.sh"
   sdk install java 17.0.12-amzn
   sdk default java 17.0.12-amzn
   ```

2. **Build and Run the Application**

   Navigate to the back-end project directory and use Maven to build and run the application:

***websocket-server***
   ```sh
   cd quiz-backend/websocket-server
   mvn clean install
   mvn spring-boot:run
   ```

   The application will start and listen for WebSocket connections on `http://localhost:8080/ws`.

***quiz-services***
   ```sh
   cd quiz-backend/quiz-services
   mvn clean install
   mvn spring-boot:run
   ```

The application will start and listen  on `http://localhost:8081`.

### Front-End

1. **Install Node.js and npm**

   Ensure that Node.js and npm are installed. You can download and install them from [nodejs.org](https://nodejs.org/).

2. **Install Project Dependencies**

   Navigate to the front-end project directory and install the required dependencies:

   ```sh
   cd quiz-webapp
   nvm use (if you have nvm in order to use the correct node version)
   npm ci
   ```

3. **Run the Front-End Application**

   Start the front-end development server:

   ```sh
   npm start
   ```

   The front-end application will be available at `http://localhost:3000`.

## Using the Front-End Application

1. **Access the Application**

   Open your web browser and navigate to `http://localhost:3000`.

2. **Join a Quiz Session**

   - Enter your User ID and Quiz Session ID in the provided fields.
   - Click the "Join Quiz" button to send a request to join the quiz session.

3. **View Quiz Status**

   - If you are allowed to join the quiz, the application will display a message indicating that you can join and a list of participants.
   - Note that only quizSessionID = 123 can join. This is for testing purpose only.
   - If you cannot join the quiz, an appropriate message will be displayed.
