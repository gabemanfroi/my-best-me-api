# Start with a base image containing Java runtime
FROM maven:3.8.4-openjdk-17-slim

# Add Maintainer Info
LABEL maintainer="manfroigab@example.com"

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Set a working directory to the source code directory
WORKDIR /src

# Copy the source code into the Docker container
COPY . /src

# Run the application using the Spring Boot Maven plugin
ENTRYPOINT ["mvn", "spring-boot:run"]
