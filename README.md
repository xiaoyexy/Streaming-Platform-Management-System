# Streaming Wars - Group 28
This is the implement of Straming Wars by group 28. 
We have proposed to add scalability, robustness and Authentication/Authorization features in our project. 
In this implementation, we use a load balance server to divide input requests to multiple front-end containers to support more users.
For robustness, we apply postgres DB to persistent all our data. We also implement a user system in front end to support log in/log out and user authorization. 
   

# Quickstart
We can simply run `make && make up` to start our service. For those that do not have `make` installed, we can effectively do the same thing by running the following:
```
docker build -t gatech/backend -f ./images/Dockerfile.backend ./backend
docker build -t gatech/web -f ./images/Dockerfile.web ./web
docker build -t gatech/nginx -f ./images/Dockerfile.nginx ./nginx
docker-compose -p gatech -f docker-compose.yml up -d
```
The first two commands are building the backend and frontend images defined by our dockerfiles, and the third is using docker-compose to deploy the service locally.
To break down the first command we can read it as "build an imageusing the `./images/Dockerfile.backend` file from the `./backend` directory and tag it as `gatech/backend`"
To break down the third command, we can read it as "deploy a service called `gatech` as defined in file `docker-compose.yml`

# docker-compose.yml
This file is well commented for additional details, and we recommend reading over this file to understand what is happening.

# Frontend
We have a single nginx service deployed on port 3000, which plays a load balance role to split input request to three different frontend servers(port 3001,3002 and 3003).
All three front end servers send requests and receive data from our backend server. The backend server is implemented using Spring Boot framework. 
The front end and back end use REST api to communicate. All data is stored in postgres DB.   
You should be able to navigate to [http://localhost:3000](http://localhost:3000) to view the front end page.

# Backend
Our backend is a simple REST controller. Users can only access the front end page. All communication between frontend and backend use REST api. 
The backend use a postgres db to store data and manage Streaming service information.

# Database
The database is postgres 9.6.12. 

# Maven 
This project uses [Apache Maven](https://maven.apache.org/) to manage itself. 
You will see the dependencies defined in `/backend/pom.xml`, and the maven commands called by the backend's Dockerfile

