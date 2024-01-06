FROM openjdk:8
ADD target/rate-service.jar  rate-service.jar
EXPOSE 9001
ENTRYPOINT ["java","-jar","/rate-service.jar"]