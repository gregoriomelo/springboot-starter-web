## Building the container image

```
gradle build
docker build --build-arg JAR_FILE=build/libs/springboot-starter-web-demo-0.0.1-SNAPSHOT.jar -t gregoriomelo/springboot-starter-web-demo .
```

## Running the container image

```
docker run -d -p 8080:8080 -t gregoriomelo/springboot-starter-web-demo
```
