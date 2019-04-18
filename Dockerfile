FROM openjdk:8
VOLUME /tmp
COPY target/mungodb-0.0.1-SNAPSHOT.jar mongo.jar
ENTRYPOINT ["java","-jar","mongo.jar"]