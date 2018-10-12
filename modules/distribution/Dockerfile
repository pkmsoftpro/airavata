
FROM ubuntu
COPY target/apache-airavata-server-0.17-SNAPSHOT-bin.tar.gz /apache-airavata-server.tar.gz
RUN mkdir airavata
RUN apt-get update  && apt-get install -y xz-utils
RUN tar -xf apache-airavata-server.tar.gz -C airavata
#RUN 'cd airavata/apache-airavata-server-0.17-SNAPSHOT/bin ; pwd'
#RUN pwd
CMD ["/airavata/apache-airavata-server-0.17-SNAPSHOT/bin/airavata-server-start.sh", "-d", "api-orch"]