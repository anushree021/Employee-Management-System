# Employee-Management-System
Employee-Management-System : Cognizant CDE Post Internship Project 

## Author
[Anushree Chakraborty](https://github.com/anushree021)

Following services are part of the application:

## Frontend
Employee Management App

## Backend
* Authorization Microservice
* Employee System Microservice
* Employee Ratings Microservice

## Requirements
* Java 17
* Angular 14

## Setup
Launch the above mentioned 3 microservices in your IDE. Import the project as Maven Project and wait for the dependencies to install. If any port is unavailable in your machine you can change the port for the respective microservice in the application.properties file under `Backend/microservice/src/main/resources/application.properties`

After the 3 microservices are up and running launch the Employee-Management-App angular application using `ng serve`

## Usage
**Initial Launch** <br/>
On initial launch of application the user is prompted with a home page of the application. In the navigation bar user can click the Login button for authentication.

**Login Portal** <br/>
User has to enter his username and password to login. Following credentials can be used to login:

| Username |	Password |
| -------- | --------- |
| anushree |	anushree12 |

## Logged In
Authenticated users can now access the features of the application from the navigation bar under their username.

### Authorization-Microservice :
This module is used for doing the Authentication and Authorization part of our project. This microsevice provides the endpoints for authentication and validation. This MS creates JWTs(JSON Web Token) for a authenticated user who is in Database and then it validates the user based on the JWT token passed in the "Authentication"-Request-Header.("Bearer j.w.t...")

--Endpoints :
| Method | Postman | URL Returns |
| ------ | ------- | ----------- |
| GET |	http://localhost:8081/auth/health-check |	String |
| POST | http://localhost:8081/auth/authenticate |	JWT Bearer Token |
| POST |	http://localhost:8081/auth/validate |	The Manager details |

### Employee-System-Microservice :
This module is used for retrieving the List of Employees, an Employee by their Id, Update employee details, Add new Employee and Delete Employee details from the H2 in-memory database.

--Endpoints :
| Method | Postman | URL Returns |
| ------ | ------- | ----------- |
| GET |	http://localhost:8082/api/v1/employees/health-check |	String |
| GET |	http://localhost:8082/api/v1/employees |	Employee List |
| GET |	http://localhost:8082/api/v1/employees/ratings |	Employee List sorted in Desc |
| GET |	http://localhost:8082/api/v1/employees/{id} |	Employee |
| POST |	http://localhost:8082/api/v1/employees |	Create new Employee |
| PUT |	http://localhost:8082/api/v1/employees/{id} |	Update Employee |
| DELETE |	http://localhost:8082/api/v1/employees/{id} |	Delete Employee |

--Dependencies on Other microsevices : Authorization Microservice

### Employee-Ratings-Microservice :
This module is used for retrieving the List of Ratings and Reviews from the H2 in-memory database.

--Endpoints :
| Method | Postman | URL Returns |
| ------ | ------- | ----------- |
| GET |	http://localhost:8083/ratings/health-check |	String |
| GET |	http://localhost:8083/ratings/ratings-list |	Ratings List |

--Dependencies on Other microsevices : Authorization Microservice
