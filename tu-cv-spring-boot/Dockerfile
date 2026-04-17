#Etapa de construccion del .jar
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests
#Etapa de ejecucion del jar y creacion de la imagen
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar pepe.jar
EXPOSE 8080
CMD ["java","-jar","pepe.jar"]