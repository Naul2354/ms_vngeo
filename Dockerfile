FROM openjdk:8u141-jre
VOLUME /opt/app
ADD target/ms_invester.jar /opt/app/ms_vngeo.jar
WORKDIR /opt/app
ENTRYPOINT exec java -jar /opt/app/ms_vngeo.jar