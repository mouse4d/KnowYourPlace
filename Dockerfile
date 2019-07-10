FROM adoptopenjdk/openjdk12-openj9:alpine-slim

WORKDIR /app

COPY kyp-0.0.1-all.jar /app


CMD ["java", "-jar", "kyp-0.0.1-all.jar"]

