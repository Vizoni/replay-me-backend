FROM maven:3.9-eclipse-temurin-25 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests


FROM eclipse-temurin:25-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENV AWS_REGION=us-east-2
ENV AWS_BUCKET_NAME=replay-me-teste-120622641290-us-east-2-an
ENTRYPOINT ["java", "-jar", "app.jar"]