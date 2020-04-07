From rohitkktr/tomcat:1

MAINTAINER rohit "rohitkktr@gmail.com">

RUN apt-get update


COPY target/HelloWorld.war /usr/local/tomcat/webapps/
