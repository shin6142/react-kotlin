FROM openjdk:17

RUN microdnf install findutils curl
WORKDIR /app
COPY start.sh .
RUN ["chmod", "+x", "start.sh"]
USER root
ENTRYPOINT ["./start.sh"]