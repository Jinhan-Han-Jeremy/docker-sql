FROM openjdk:17-alpine

LABEL authors="user"

WORKDIR /app

COPY ./2024-msg-server.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]