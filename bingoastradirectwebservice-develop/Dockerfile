#####RUN THE APP ##########
# java 21
FROM eclipse-temurin:21

# allow buildscript to pass in current env
ARG CURENV
ENV BINGOENV=$CURENV

# create dir for jar
RUN mkdir /opt/app

# adjust pwd
WORKDIR /opt/app

# copy from host to container
COPY target/*.jar app.jar

### WE NEED TO SET THE CORRECT TIMEZONE for the JAVA VM
ENV TZ=Europe/Berlin
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ENTRYPOINT java -Dbingo.env=$BINGOENV -Dspring.profiles.active=$BINGOENV -Djava.security.egd=file:/dev/./urandom -jar app.jar