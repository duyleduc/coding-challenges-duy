# Quiz real time Application Backend with Spring Boot and WebSocket

## Table of Contents
1. [Introduction](#introduction)
2. [Modules](#modules)
    - [websocket-server](#websocket-server)
    - [quiz-services](#quiz-services)
    - [domain](#domain)
    - [configuration](#configuration)
    - [common](#common)
3. [Setup Instructions](#setup-instructions)
4. [Running the Application](#running-the-application)
5. [APIs and Endpoints](#apis-and-endpoints)
6. [Contributing](#contributing)
7. [License](#license)

## Introduction
This project is a Spring Boot-based backend for a Quiz real time application that utilizes WebSockets to enable real-time messaging. The architecture is modularized to separate different concerns such as WebSocket communication, quiz services, domain models, configuration settings, and common utilities.

## Modules

### websocket-server
This module handles WebSocket connections, message routing, and broadcasting messages to different Quiz Sessions.

- **Responsibilities**:
    - Configuring WebSocket endpoints.
    - Defining message handling mechanisms.
    - Broadcasting messages to specific chat room topics.

### quiz-services
This module manages the quiz-related services. While the primary focus is the quiz functionality, this module showcases how additional services can be integrated into the application.

- **Responsibilities**:
    - Handling quiz-related business logic.
    - Managing quiz data and interactions.

### domain
This module contains the domain models used across the application. These models represent the core entities of the system.

- **Responsibilities**:
    - Defining the data structures for chat messages, users, and quizzes, quiz sessions.

### configuration
This module includes all configuration-related classes, such as WebSocket configurations, application properties, and security configurations.
The purpose is for externalization configurations

### common
This module contains common utilities and helper classes used across different modules.

- **Responsibilities**:
    - Providing utility functions and common constants.
    - Managing application-wide exceptions and error handling.

## Setup Instructions

### Prerequisites
- Java 11 or higher
- Maven
- IDE (e.g., IntelliJ)

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/chat-application-backend.git
   cd chat-application-backend
   ```

2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

3. Configure application properties in `src/main/resources/application.properties` as per your requirements.

## Running the Application
1. Run the Spring Boot application:
   ```bash
   # Enter to each module (websocket-server, quiz-services)
   mvn spring-boot:run
   ```
