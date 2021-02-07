FROM adoptopenjdk/openjdk11:jdk-11.0.6_10-alpine-slim
ADD ./target/LifoAssignment-0.0.1-SNAPSHOT.jar LifoAssignment-0.0.1-SNAPSHOT.jar
EXPOSE 7000
CMD ["java","-jar","LifoAssignment-0.0.1-SNAPSHOT.jar"]