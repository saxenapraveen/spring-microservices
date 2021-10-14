FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} frontend.jar
ENTRYPOINT ["java", "-jar", "/frontend.jar"]
EXPOSE 9003