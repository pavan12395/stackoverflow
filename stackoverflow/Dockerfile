FROM alpine:latest

ENV JAVA_HOME="/usr/lib/jvm/default-jvm/"
RUN apk add openjdk11

# Has to be set explictly to find binaries
ENV PATH=$PATH:${JAVA_HOME}/bin
ARG BUILD_FOR=prod

LABEL Description="This image is used to start stackoverflow service"

RUN apk update && apk add tzdata
RUN cp /usr/share/zoneinfo/Asia/Kolkata  /etc/localtime
RUN echo "Asia/Kolkata" >  /etc/timezone

RUN mkdir stackoverflow

COPY target /stackoverflow/target
WORKDIR /stackoverflow

CMD export USER_ADDED_ENDPOINT="http://${NODE_HOST}:${NODE_PORT}/userAdded" && \
export database_url="mysql://${DB_HOST}:${DB_PORT}/${DB_NAME}" && \
export database_username=${DB_USER_NAME} && \
export database_password=${DB_PASSWORD} && \
export USER_ADDED_API_KEY=${API_KEY} && \
java -cp target/stackoverflow-1.0-SNAPSHOT.jar mlh.pavan.GrpcServer