FROM eclipse-temurin:17-jdk-jammy
COPY app.jar /tsn/app.jar
COPY stream_set.pat /tsn/streams.pat
COPY topology.top /tsn/topology.top
CMD ["java","-jar","/tsn/app.jar"]

