### Build/Run

Open terminal on Intellij/Eclipse

```
mvn clean install
```

After this command check if the war has been created in target folder

```
docker-compose up --build
```
### APIs

These apis should only be available for the application owner
 
- Admin User registration page        <http://localhost:8080/attendance/>
- View AdminUsers and their Password  <http://localhost:8080/attendance/users>

These apis should be used by angular projects

- Login Admin User  (POST) <http://localhost:8080/attendance/login>
- Add Member        (POST) <http://localhost:8080/attendance/member>
- Get Members       (GET)  <http://localhost:8080/attendance/member>
- Get Member by Id  (GET)  <http://localhost:8080/attendance/member/{memberId}>

#### Request for login

{
    "username":"rohan",
    "password":"dsouza"
}

#### Response for login

##### If the username is not available in database
{
    "code": "404",
    "message": "User not found in our database"
}

##### If username is available but password is incorrect

{
    "code": "401",
    "message": "Incorrect Password"
}

##### If username and password is correct

{
    "code": "0",
    "message": "Successful Login"
}


### Technology Stack
* Java 8, Spring Boot 2.3.1.RELEASE
* Postgres
* Docker
* Git



### This project is owned by Rohan and Michael
