FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8080
ADD target/movie-finder.jar movie-finder.jar
ENTRYPOINT ["java","-jar","/movie-finder.jar"]


