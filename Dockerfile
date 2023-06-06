FROM openjdk:11 AS build

COPY pom.xml mvnw ./
RUN chmod +x mvnw
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package


FROM openjdk:11
WORKDIR blog
COPY --from=build target/tournament-0.0.1-SNAPSHOT.jar tournament.jar
ENTRYPOINT ["java", "-jar", "tournament.jar"]
