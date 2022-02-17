FROM openjdk:11
WORKDIR /
ADD target/order-service-0.0.1-SNAPSHOT.jar order-service-0.0.1-SNAPSHOT.jar
EXPOSE 8085
CMD java -jar order-service-0.0.1-SNAPSHOT.jar