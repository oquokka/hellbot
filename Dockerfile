FROM openjdk:21-slim as BuildJava
ARG JAR_FILE=build/libs/stocks-be-0.1.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]