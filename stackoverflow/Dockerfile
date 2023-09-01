FROM alpine:latest

ENV JAVA_HOME="/usr/lib/jvm/default-jvm/"
RUN apk add openjdk11

# Has to be set explictly to find binaries
ENV PATH=$PATH:${JAVA_HOME}/bin
ARG BUILD_FOR=prod

LABEL Description="This image is used to start payout service" Vendor="nurture.payout" Version="1.0"

RUN apk update && apk add tzdata
RUN cp /usr/share/zoneinfo/Asia/Kolkata  /etc/localtime
RUN echo "Asia/Kolkata" >  /etc/timezone

RUN mkdir stackoverflow

COPY target /stackoverflow/target
WORKDIR /stackoverflow

CMD ["java","-cp","target/stackoverflow-1.0-SNAPSHOT.jar","mlh.pavan.GrpcServer"]