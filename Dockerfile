FROM openjdk:23
LABEL authors="josea"
WORKDIR /app
COPY target/semestre-service-0.0.1-SNAPSHOT.jar /app
ENTRYPOINT ["java", "-jar", "semestre-service-0.0.1-SNAPSHOT.jar"]