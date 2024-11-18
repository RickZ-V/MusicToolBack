FROM amazoncorretto:21-alpine-jdk

COPY target/GRUPO1-MUSICTOOL-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]