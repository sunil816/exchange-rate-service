# exchange-rate-service
Exchange Rate Service

API Collection for User Stories: https://www.getpostman.com/collections/f326a9e6a12cf4c75632

To build, test, and run the application in docker please follow below steps:
  a. Build: cd to the current path and create an image of the application:
     docker build -t exchange-rate-service-api .
  b. To Run the docker app please execute below command which will run the app locally on port 8080
     docker run -p 8080:8080 exchange-rate-service-api
  c. For testing the app on docker please run the api collections mentioned above. 
