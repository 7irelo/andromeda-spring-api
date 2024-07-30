FROM openjdk:22-jdk
COPY target/andromeda-spring-api.jar andromeda-spring-api.jar
ENTRYPOINT ["java", "-jar", "/andromeda-spring-api.jar"]
