# Build stage
FROM maven:3.9.6-eclipse-temurin-21-jammy AS build
COPY pom.xml /app/
COPY src /app/src
RUN mvn -f /app/pom.xml clean package


FROM azul/zulu-openjdk-alpine:21-latest
LABEL authors="watho"
VOLUME /tmp
COPY --from=build /app/target/*.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]