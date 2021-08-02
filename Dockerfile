FROM openjdk:11
COPY target/*.jar app.jar
ENTRYPOINT [вщслук "java","-jar","/app.jar"]