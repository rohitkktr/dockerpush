From rohitkktr/tomcat:1

MAINTAINER rohit "rohitkktr@gmail.com">

RUN apt-get update


COPY target/*.war /usr/local/tomcat/webapps/
