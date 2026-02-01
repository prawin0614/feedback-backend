# Use a Java 17 base image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy the jar file built by Maven into the container
COPY target/complaintmanagement-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Command to run the jar
ENTRYPOINT ["java","-jar","app.jar"]
