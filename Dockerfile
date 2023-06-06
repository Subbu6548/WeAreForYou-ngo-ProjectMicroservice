#define base docker image
FROM openjdk:17
COPY target/project-microservices-0.0.1-SNAPSHOT.jar project-microservices.jar
ENTRYPOINT ["java", "-jar", "/project-microservices.jar"]
