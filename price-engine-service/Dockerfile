FROM openjdk:8-jdk-alpine
EXPOSE 8294
ADD target/*.jar price-engine-service.jar
ENTRYPOINT [ "sh", "-c", "java -jar /price-engine-service.jar" ]