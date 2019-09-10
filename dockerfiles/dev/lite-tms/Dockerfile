FROM tomcat:jre8

RUN rm -rf /usr/local/tomcat/webapps/*
COPY lite-tms.war /usr/local/tomcat/webapps/ROOT.war
COPY tomcat-users.xml /usr/local/tomcat/conf/
COPY catalina.properties /usr/local/tomcat/conf/
COPY tomcat_server_conf.xml /usr/local/tomcat/conf/server.xml

ENV JPDA_ADDRESS=9000
ENV JPDA_TRANSPORT=dt_socket

EXPOSE 80
EXPOSE 8080
EXPOSE 443
EXPOSE 9000
CMD ["catalina.sh", "jpda", "run"]
