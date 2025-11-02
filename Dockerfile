# Use official OpenJDK runtime
FROM openjdk:17-jdk-slim

# Copy jar file from Maven target directory
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]