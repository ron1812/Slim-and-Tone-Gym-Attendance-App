FROM tomcat:8.0-jre8
ADD target/attendance.war /usr/local/tomcat/webapps

ENV JPDA_ADDRESS 18000
ENV JPDA_TRANSPORT=dt_socket

EXPOSE 8080

CMD ["catalina.sh", "jpda", "run"]
