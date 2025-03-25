# Use a lightweight Java image
FROM openjdk:21-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy the built jar file into the container
COPY target/golf-club-api-1.0.0.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
