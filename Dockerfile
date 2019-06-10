FROM openjdk:11-jdk-stretch
WORKDIR /src/muzix
ADD /target/Muzix-0.0.1-SNAPSHOT.jar /src/muzix/Muzix-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "Muzix-0.0.1-SNAPSHOT.jar"]