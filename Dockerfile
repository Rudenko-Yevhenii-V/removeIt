FROM eclipse-temurin:17-jdk-alpine as base

MAINTAINER Rudenko Yevhenii rydwowe@gmail.com

RUN addgroup -S appgroup && adduser -S appuser -G appgroup

WORKDIR /app

COPY --chown=appuser:appgroup ./target/testTask-1.0.0.jar app.jar

RUN chmod +x app.jar

USER appuser

EXPOSE 8087

ENTRYPOINT exec java $JAVA_OPTS -jar app.jar