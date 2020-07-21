FROM openjdk:11

# Add the service itself
COPY ./target/app.jar /usr/share/app/

ENTRYPOINT ["java", "-jar", "/usr/share/app/app.jar"]

EXPOSE 8080