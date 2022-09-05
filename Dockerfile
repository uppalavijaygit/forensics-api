FROM openjdk:11
ADD target/forensics-api-0.0.1-SNAPSHOT.jar forensics-api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "forensics-api.jar"]