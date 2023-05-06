# Use an official Node.js runtime as a parent image
FROM node:15.14.0-alpine3.10 as node

# Set the working directory to /app
WORKDIR /app

# Copy the package.json and package-lock.json to the container
COPY angular-15-client/package*.json ./

# Install Angular CLI
RUN npm install -g @angular/cli@15.0.3

# Install the dependencies
RUN npm install

# Copy the rest of the application code to the container
COPY angular-15-crud .

# Build the application
RUN npm run build -- --prod

# Use an official Maven runtime as a parent image
FROM maven:3.8.3-openjdk-11-slim

# Set the working directory to /app
WORKDIR /spring-boot-server

# Copy the pom.xml to the container
COPY spring-boot-towerdata-demo/pom.xml .

# Install the dependencies
RUN mvn dependency:go-offline

# Copy the rest of the application code to the container
COPY spring-boot-towerdata-demo .

# Build the application
RUN mvn clean install

# Use an official OpenJDK runtime as a parent image
FROM openjdk:8-jre-slim

# Set the working directory to /app
WORKDIR /app

# Copy the JAR file from the Maven build stage to the container
COPY --from=1 /app/target/spring-boot-towerdata-demo-0.0.1-SNAPSHOT.jar .

# Copy the built Angular app from the Node.js build stage to the container
COPY --from=node /app/dist/angular-15-client .

# Set the environment variables
ENV PORT=8081
ENV SPRING_PROFILES_ACTIVE=prod

# Expose the port
EXPOSE 8081

# Start the application
CMD ["java", "-jar", "spring-boot-towerdata-demo-0.0.1-SNAPSHOT.jar"]
