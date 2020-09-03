FROM java:8-jre
WORKDIR /usr/src
ADD ./target/zuulservice-0.0.1-SNAPSHOT.jar /usr/src/zuulservice.jar
ENTRYPOINT ["java", "-jar", "zuulservice.jar"]