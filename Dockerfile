FROM openjdk:17
COPY target/test-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","test-0.0.1-SNAPSHOT.jar"]