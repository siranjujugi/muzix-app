FROM java:8-jre
WORKDIR /usr/src
ADD ./target/orchestrationservice-0.0.1-SNAPSHOT.jar /usr/src/orchestrationservice.jar
ENTRYPOINT ["java", "-jar", "orchestrationservice.jar"]