FROM java:8-jre
WORKDIR /usr/src
ENV MYSQL_URL=jdbc:mysql://localhost:3306/userdb
ENV MYSQL_DATABASE=userdb
ENV MYSQL_USER=approot
ENV MYSQL_PASSWORD=root123
ADD ./target/authenticationservice-0.0.1-SNAPSHOT.jar /usr/src/authenticationservice.jar
ENTRYPOINT ["java", "-jar", "authenticationservice.jar"]