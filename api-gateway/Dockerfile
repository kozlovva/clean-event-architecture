FROM bellsoft/liberica-openjdk-alpine-musl:latest
MAINTAINER Kozlov Vladimir <kozlovva@sushivesla.team>

ADD  target/${project.build.finalName}.jar /app/
CMD ["java", "-jar", "/app/${project.build.finalName}.jar"]

EXPOSE 8080