FROM openjdk:8
ENV workdir=/root/eureka-server-docker
COPY . ${workdir}
WORKDIR ${workdir}
EXPOSE 8761
CMD ["java","-jar","eureka-server-1.0.jar"]
