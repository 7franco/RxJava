# --- Etapa de construcción ---
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# 1. Copiar solo el wrapper y el pom primero para aprovechar el caché de capas
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
# Dar permisos y descargar dependencias (esto se saltará si no cambias el pom.xml)
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

# 2. Copiar el código fuente y compilar
COPY src ./src
RUN ./mvnw clean package -DskipTests

# --- Etapa de ejecución ---
FROM eclipse-temurin:21-jre
WORKDIR /app

# 3. Copiar el jar (ajusta el nombre si sabes el exacto para evitar conflictos de comodines)
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]