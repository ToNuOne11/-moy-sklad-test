FROM openjdk:21-jdk-slim-buster
WORKDIR /app
COPY /target/romashka-1.0.jar /app/romashka.jar
ENTRYPOINT ["java", "-jar", "romashka.jar"]
