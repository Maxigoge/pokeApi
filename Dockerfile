
FROM eclipse-temurin:17-jdk-jammy
# copio el jar al directorio /app
COPY ./service/build/libs/service.jar /app/app.jar
# inicio el servidor
CMD ["java", "-server", "-Xmx512M", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000", "-Xss384K", "-jar", "/app/app.jar"]
