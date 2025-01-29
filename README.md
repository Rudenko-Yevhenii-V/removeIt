[test app] BACKEND demo for Wamisoftware
--------------

Backend APIs for Wamisoftware.

### Technologies
<hr style="border: 2px solid gray" />

- Java 17
- Spring Boot 2.5.0
- Swagger, Lombok
- Maven, Docker

### Requirements
<hr style="border: 2px solid gray" />

- JDK 15+
- Docker, docker-compose

**Build jar file**

**Navigate to project directory**

`mvn clean install`

**Execute jar file**

```bash
java -jar target/testTask-1.0.0.jar
```

### OR use docker-compose

```bash
docker-compose up --build
```

### Swagger. REST APIs Documentation
<hr style="border: 2px solid gray" />

- Swagger UI endpoint: http://localhost:8087/swagger-ui.html
