FROM eclipse-temurin:21.0.2_13-jre-alpine

EXPOSE 8080
WORKDIR /app

COPY target/demo-app.jar demo-app.jar
ENTRYPOINT ["java", "-jar", "demo-app.jar"]
