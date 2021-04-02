FROM openjdk:11
COPY ./build/libs/fpl-datter-1.0-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 9999
ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,address=9990,server=y,suspend=n", "-jar", "fpl-datter-1.0-SNAPSHOT.jar"]