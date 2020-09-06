FROM tomcat:8.0-jre8
ADD target/attendance.war /usr/local/tomcat/webapps

ENV JPDA_ADDRESS 18001
ENV JPDA_TRANSPORT=dt_socket

EXPOSE 8082

CMD ["catalina.sh", "jpda", "run"]
