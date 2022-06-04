FROM openjdk:11
WORKDIR /app
COPY target/backend-financeiro-0.0.1-SNAPSHOT.jar /app/backendfinanceiro.jar

ENTRYPOINT ["java", "-jar", "backendfinanceiro.jar"]

EXPOSE 8080
