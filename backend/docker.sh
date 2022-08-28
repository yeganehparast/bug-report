mvn spring-boot:build-image
docker run -it -p 8080:8080 --name backend backend:1.0