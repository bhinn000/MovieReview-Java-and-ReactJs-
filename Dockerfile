# Use an official OpenJDK runtime as a parent image (Java 17)
FROM openjdk:17


# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY MovieReview/target/Movies-0.0.1-SNAPSHOT.jar /app/Movies-0.0.1-SNAPSHOT.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/Movies-0.0.1-SNAPSHOT.jar"]
