# Utiliza la imagen base de OpenJDK para Java 17 en Alpine Linux
FROM openjdk:17-jdk-alpine

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia el contenido local al directorio /app en el contenedor
COPY . /app

# Define el comando por defecto para ejecutar tu aplicación
CMD ["java", "-jar", "pokemonRestApi-1.0-SNAPSHOT.jar"]
