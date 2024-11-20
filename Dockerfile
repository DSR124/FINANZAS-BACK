FROM maven:3.9.3-eclipse-temurin-17 AS build

COPY pom.xml .

COPY src ./src/

RUN mvn -X -f pom.xml clean package -DskipTests

FROM openjdk:17-jdk-slim

COPY --from=build target/TF_FINANZAS-0.0.1-SNAPSHOT.jar /app/TF_FINANZAS-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/TF_FINANZAS-0.0.1-SNAPSHOT.jar"]