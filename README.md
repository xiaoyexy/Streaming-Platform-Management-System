# Example Dockerized Java Service

This repository contains an example Java service to help get your group project started.
It contains two Docker separate service to demonstrate a how we may deploy a separate service for an application server and a front end service. In this example, we have a simple Java backend that uses [Spring Boot](https://spring.io/projects/spring-boot) as our web service framework, and an [nginx](https://www.nginx.com/) web server that serves our html file.

For your convenience we have defined a [docker-compose](https://docs.docker.com/compose/) file to help define our application and orchestrate the deployment locally, as well as a [Makefile](https://www.gnu.org/software/make/manual/make.html) that effectively wraps some build commands for you.

# Quickstart
We can simply run `make && make up` to start our service. For those that do not have `make` installed, we can effectively do the same thing by running the following:
```
docker build -t gatech/backend -f ./images/Dockerfile.backend ./backend
docker build -t gatech/frontend -f ./images/Dockerfile.frontend ./frontend
docker-compose -p gatech -f docker-compose.yml up -d
```
The first two commands are building the backend and frontend images defined by our dockerfiles, and the third is using docker-compose to deploy the service locally.
To break down the first command we can read it as "build an imageusing the `./images/Dockerfile.backend` file from the `./backend` directory and tag it as `gatech/backend`"
To break down the third command, we can read it as "deploy a service called `gatech` as defined in file `docker-compose.yml`

# docker-compose.yml
This file is well commented for additional details, and we recommend reading over this file to understand what is happening.

# Frontend
The front end service defines a single html file that calls our backend service and displays the randomly generated value. Our nginx service is deployed on port 3001
You should be able to navigate to [http://localhost:3001](http://localhost:3001) to view the page

# Backend
Our backend is a simple application controller that defines an endpoint `/random`. This simply generates a random number, saves it to the database, and returns it as a response.
This service (as defined in our docker-compose file) is exposed on port 8080.
It is important to note that since our backend and frontend are split between two containers, we need to deal with [cross-origin resource sharing](https://en.wikipedia.org/wiki/Cross-origin_resource_sharing). Youu see that this application has been pre-defined to allow our front end service to access our backend using Spring's `@CrossOrigin` annotation. If you deviate from our starter code, and split your frontend container from your backend, you will also need to ensure your web application sets this response header.
Our backend is bootstrapped to communicate with our database container using the Java Persistenace API (JPA) with Hibernate.
You will see the configuration in the `application.properties` file. Note that we have hibernate configured to automatically create the table as needed

In addition to the `/random` endpoint, there is a `/list` endpoint which simply returns the list all previously generated numbers.
`curl http://localhost:8080/list` or navigate to [http://localhost:8080/list](http://localhost:8080/list) to view the returned JSON object

A lot of this backend uses the [Spring Boot](https://spring.io/projects/spring-boot) framework. Take a look at the documentation to familiarize yourself with it.

# Database
The database is postgres 9.6.12. This should be sufficient for most student use cases.

# Maven 
This project uses [Apache Maven](https://maven.apache.org/) to manage itself. 
You will see the dependencies defined in `/backend/pom.xml`, and the maven commands called by the backend's Dockerfile

# Testing
We have also bootstrapped unit tests to run when building the container. You will find an empty backend test suite in `backend/src/test/java/edu/gatech/streamingwars/`
Note that since our application normally depends on a database, we deploy the in memory [h2 database](https://www.h2database.com/html/main.html) for our tests.
You will see that test are separately configured by the `application-test.properies` file
