FROM openjdk:8u262-jdk
MAINTAINER terje2018@163.com

WORKDIR /spring_boot_demo

EXPOSE 8666
VOLUME /spring_boot_demo/logs

COPY . /spring_boot_demo

RUN chmod u+x /spring_boot_demo/bin/start.sh && \
chmod o+x /spring_boot_demo/bin/start.sh && \
chmod u+x /spring_boot_demo/bin/kill.sh && \
chmod o+x /spring_boot_demo/bin/kill.sh

ENTRYPOINT "/spring_boot_demo/bin/./start.sh"