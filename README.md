# WebService-Mapper

Microservice for transforming incoming application data into the required JSON format for downstream systems.

The service consumes messages asynchronously via **RabbitMQ**, 
validates and normalizes the incoming JSON into internal Java models, 
transforms them into the required output structure, and publishes or returns the resulting JSON to the next service.

## Features
- Asynchronous message processing via **RabbitMQ**
- JSON → Java → JSON transformation using **Jackson**
- Input validation & normalization
- Stateless processing (no database)
- Designed as part of a multi-service insurance workflow

## Tech Stack
Java 21 · Spring Boot 3 · RabbitMQ · WebFlux · Jackson · Maven

## Flow

![jsonToJson](https://github.com/user-attachments/assets/93a8100c-be46-45bc-8425-8d179c1b63a7)
