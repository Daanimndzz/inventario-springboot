# Cambiamos de 17 a 21 para que coincida con tu ordenador
FROM eclipse-temurin:21-jdk-alpine

COPY target/inventario-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]