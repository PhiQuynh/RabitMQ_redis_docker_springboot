FROM maven:3.8.2-jdk-8
VOLUME /tmp
ADD target/springboot-mysql-docker.jar springboot-mysql-docker.jar
ENTRYPOINT ["java","-jar","/springboot-mysql-docker.jar"]

#FROM openjdk:8-jdk-alpine
#ARG JAR_FILE=target/*.jar
#COPY ./target/springboot-mysql-docker.jar springboot-mysql-docker.jar
#ENTRYPOINT ["java", "-jar", "/springboot-mysql-docker.jar"]