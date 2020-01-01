FROM java:8
VOLUME /tmp
ADD /target/kefubbs-0.0.1-SNAPSHOT.jar kefubbs.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","kefubbs.jar"]