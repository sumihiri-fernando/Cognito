# Administration and security in a cloud environment

AWS Cognito provides secure and scalable user authentication, authorization, and user management. Integrating Cognito with a Spring Boot application allows developers to leverage these features for their web applications.

## Setup Instructions

### 1. Create the User Pool on AWS Cognito

1. Sign in to the AWS Management Console and open the Amazon Cognito console.
2. Create a user pool and configure the settings as per your requirements.
3. Create an app client and configure the callback URL(s) and OAuth flows.
4. Note down the user pool ID, app client ID, and app client secret.

### 2. Create a Spring Boot Project

1. Use Spring Initializr to create a new Spring Boot project with the required dependencies.
2. Extract the project and open it in your preferred IDE.

### 3. Connect Your Project to AWS Cognito

1. Add the necessary dependencies in `pom.xml`.
2. Configure Cognito properties in `application.yml`.
3. Implement Spring Security configuration.

### 4. Implement User Registration, Login, and Account Deletion

1. Create the necessary controllers and views for user registration login and delete.
2. Implement the account deletion logic using AWS Cognito's configuration API.
3. Call the user deletion service from the controller.

## Code Documentation

### Dependencies

Add the following dependencies to `pom.xml`:

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-oauth2-client</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.thymeleaf.extras</groupId>
			<artifactId>thymeleaf-extras-springsecurity6</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-oauth2-jose</artifactId>
		</dependency>
		<dependency>
			<groupId>software.amazon.awssdk</groupId>
			<artifactId>cognitoidentityprovider</artifactId>
			<version>2.25.54</version>
		</dependency>`


### Configuration
Configure Cognito properties in application.yml:

### Security Configuration
Implement Spring Security configuration in SecurityConfig.java:

### Controller
Create Controller.java to handle user-related requests:

### Service
Implement UserService.java to handle AWS Cognito operations:

### Model
Modify the UserService to include a method that retrieves user information from Cognito and populates a User object:

### HTML and CSS for Registration and Login

##Features

### Registration
Users can register by providing a username, email, and password. The registration data is sent to AWS Cognito.

### Login
Users can log in using their username and password. Authentication is handled by AWS Cognito.

### Account Deletion
Logged-in users can delete their accounts and all associated personal data.

### How Users Can Delete Their Data
To delete an account, users can send a DELETE request to /deleteAccount with their username. This will remove their account from AWS Cognito.

### Access the application:
Open your browser and navigate to `http://localhost:8080`.

## Identify Issues

### Reporting Bugs
If you encounter any bugs, please follow these steps:

Search for existing issues: Before creating a new issue, check the issues list to see if the problem has already been reported.