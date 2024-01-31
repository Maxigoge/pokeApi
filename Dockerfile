FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .
# Otorga permisos de ejecución al script gradlew.
RUN chmod +x ./gradlew

RUN ./gradlew bootJar --no-daemon

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /build/libs/pokemonRestApi-1.jar app.jar



ENTRYPOINT ["java", "-jar", "app.jar"]