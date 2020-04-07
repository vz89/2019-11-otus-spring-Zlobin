FROM maven:3.6.3-jdk-11

ENV PROJECT_DIR=/opt/project
RUN mkdir - p $PROJECT_DIR
WORKDIR $PROJECT_DIR

COPY . $PROJECT_DIR

RUN mvn clean install -DSkipTests

FROM openjdk:11

ENV PROJECT_DIR=/opt/project
RUN mkdir -p $PROJECT_DIR
WORKDIR $PROJECT_DIR

COPY --from=0 $PROJECT_DIR/target/homework-1.0-SNAPSHOT.jar $PROJECT_DIR

EXPOSE 8080
CMD ["java","-jar","/opt/project/homework-1.0-SNAPSHOT.jar"]

