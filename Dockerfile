FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar address-api.jar
ENTRYPOINT ["java","-jar","/address-api.jar"]