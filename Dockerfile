FROM maven:3.6.2-jdk-8 AS build 
COPY src /usr/app/src  
COPY pom.xml /usr/app
WORKDIR /usr/app
RUN mvn clean package

FROM gcr.io/distroless/java
ENV VERSION 0.0.1
COPY --from=build /usr/app/target/shop-service-$VERSION.jar /usr/app
EXPOSE 7500  
ENTRYPOINT ["java","-jar","/usr/app/shop-service-0.0.1.jar"]