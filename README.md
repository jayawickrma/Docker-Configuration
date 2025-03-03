# Docker Guide

## Introduction to Docker
Docker is a tool used for creating, managing, and running containers. A **Docker container** packages an application with all its dependencies, making it easy to run anywhere.

## Creating a JAR File
To create a JAR file for your Java application, follow these steps:

1. Open your terminal and navigate to the project directory.
2. Run the following commands:
   ```sh
   mvn clean
   mvn package
   ```
3. Check the `target` folder for the generated `.jar` file.

Ensure your `pom.xml` contains the following:
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
    <finalName>LogBuildFile</finalName>
</build>
```
The JAR file name will be based on `<finalName>` or, if not specified, `<artifactId>-<version>.jar`.

## Creating and Running a Docker Image

### Check if Docker is Installed
```sh
docker --version
```

### Build a Docker Image
```sh
docker build -t logBuild-test .
```
- `logBuild-test` is the image name.
- The `Dockerfile` must be in the same directory.

### List Docker Images
```sh
docker images
```

### Run a Docker Image
```sh
docker run -p 8085:8080 log-67
```
- `8085` is the machine's real port.
- `8080` is the application's internal port.
- `log-67` is the Docker image name.

#### Run in Detached Mode
```sh
docker run -d -p 8085:8080 log-67
```
- `-d` ensures the container runs in the background.

### Check Running Containers
```sh
docker ps
```
- Shows only currently running containers.

```sh
docker ps -a
```
- Shows all containers (running or stopped).

### Stop a Running Container
```sh
docker stop <container_id>
```
Find `<container_id>` from `docker ps`.

### Remove a Container
```sh
docker rm <container_id>
```

### Remove a Docker Image
```sh
docker rmi log-67
```
Force removal if necessary:
```sh
docker rmi -f log-67
```

## Using Docker Hub
Docker Hub is used to store and share Docker images.

### Login to Docker Hub
```sh
docker login
```
- Follow the prompts and enter your credentials.

### Tag an Image for Docker Hub
```sh
docker tag log-67 dockerUsername/log-67
```
- Replace `dockerUsername` with your Docker Hub username.

### Push an Image to Docker Hub
```sh
docker push dockerUsername/log-67:latest
```
- `:latest` can be replaced with a version tag if needed.

### Pull an Image from Docker Hub
```sh
docker pull dockerUsername/logManagement
```

### Run Pulled Image
```sh
docker run -d -p 8085:8080 dockerUsername/logManagement
```

## Viewing Docker Logs
```sh
docker logs <container_id>
```
- Replace `<container_id>` with the actual container ID to view logs.

---
This guide provides a step-by-step approach to building and managing Docker containers for your Java application. Feel free to modify and enhance it for your use case!
