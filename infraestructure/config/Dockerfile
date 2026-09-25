#base image
FROM amazoncorretto:17
#version de java libre

#create directory
WORKDIR /app
#directorio para la aplicacion

#copy jar into image
COPY MicroserviceConfig-1.0.0.jar .
#imagen a copiar en el directorio

#document port es donde se levantaba el microservicio de configuracion en springtools
EXPOSE 7777

#init application analogo a java -jar MicroserviceConfig-1.0.0.jar
ENTRYPOINT ["java"]
CMD ["-jar", "MicroserviceConfig-1.0.0.jar"]