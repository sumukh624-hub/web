FROM tomcat:11.0-jdk17
COPY target/sample-webapp.war /usr/local/tomcat/webapps/
EXPOSE 8080