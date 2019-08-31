FROM java:8

MAINTAINER yibo haoyizebo@mail.com

VOLUME /tmp

ARG JAR_FILE
ADD ${JAR_FILE} app.jar

EXPOSE 8761

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]