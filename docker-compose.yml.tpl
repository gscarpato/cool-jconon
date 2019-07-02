jconon:
  image: docker.si.cnr.it/##{CONTAINER_ID}##
  mem_limit: 1024m
  read_only: false
  environment:
  - LANG=it_IT.UTF-8
  - REPOSITORY_BASE_URL=http://as1dock.si.cnr.it:8080/alfresco/
  volumes:
  - ./webapp_logs:/logs
  - /tmp
  command: java -Xmx256m -Xss512k -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8787 -Djava.security.egd=file:/dev/./urandom -jar /opt/jconon.war
  labels:
  - SERVICE_NAME=##{SERVICE_NAME}##