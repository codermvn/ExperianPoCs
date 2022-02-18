FROM openjdk:11
WORKDIR /
ADD target/CustomerService-0.0.1-SNAPSHOT.jar CustomerService-0.0.1-SNAPSHOT.jar
EXPOSE 8082
CMD java -jar CustomerService-0.0.1-SNAPSHOT.jar