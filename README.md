## Bug report

This is a simple project to practice API first approach in defining RESTful APIs with Open API 3.0.

#### The project is structured based on two modules

- Specification
  Api specification is defined in the resources. It will be read by the openapi-maven plugin and
  then,
  generates the code to the backend module.
- Backend
  is structured based on the microservices architecture for a resource e.g. Bug. It uses the H2
  in-memory
  db. The service layer is tested (unit test) and an integration test provided for API endpoint.

#### Build

`mvn clean package`

Note: you need docker installed on your pc. The command will create docker image. The following
command will run the image for you.

`docker run -it -p 8080:8080 --name backend backend:1.0`
