# Forensics API - Version 1.0

This Forensics API will help to locate woman who run off with cats.

#### Pre-Requisites
* Java11
* Maven

##### Swagger: 

```aidl
http://localhost:8080/swagger-ui/index.html
```

### Endpoints

* Directions - This API will return the all directions of the women while running off with cats
```aidl
http://localhost:8080/api/v1/valid@email.com/directions
```

* Location - This API will validate the Guessing Position
```aidl
http://localhost:8080/api/v1/uppalavijay@gmail.com/location/5/-15
```

### Testing
```aidl
mvn clean test
```

### Docker file Path
```aidl
/forensics-api/Dockerfile
```
### Running the Application

Open the Terminal in the project folder and execute below command
```aidl
mvn spring-boot:run
```

You can also run the Application using the IDE

Once opened the code in the IDE , please click on the Run Button

### Building  the Application

Open the Project in the IntelIj Idea IDE and Click on Maven Tab on the Right-Hand Panel and Click the Build

or

```aidl
mvn spring-boot:build
```

