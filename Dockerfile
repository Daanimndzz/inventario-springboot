# --- ETAPA 1: CONSTRUIR (Build) ---
# Usamos una imagen que tiene Maven instalado para fabricar el .jar
FROM maven:3.9-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# --- ETAPA 2: EJECUTAR (Run) ---
# Usamos una imagen ligera de Java solo para correrlo (como antes)
FROM eclipse-temurin:21-jdk-alpine
# Aquí está la magia: Copiamos el .jar que fabricamos en la Etapa 1
COPY --from=build /app/target/inventario-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]