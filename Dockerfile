FROM eclipse-temurin:17-jdk-alpine
LABEL authors="watho"
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]