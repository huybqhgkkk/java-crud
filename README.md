# java-crud
This project explains CRUD operations using MongoTemplate and MongoRepository using spring boot and mongo DB.

## Prerequisites
- Java
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/guides/index.html)
- [Mongo DB](https://docs.mongodb.com/guides/)
- [Lombok](https://objectcomputing.com/resources/publications/sett/january-2010-reducing-boilerplate-code-with-project-lombok)

## Tools
- Eclipse or IntelliJ IDEA (or any preferred IDE) with embedded Gradle
- Maven (version >= 3.6.0)
- Postman (or any RESTful API testing tool)

###  Build and Run application
_GOTO >_ **~/absolute-path-to-directory/spring-boot-mongodb**  
and try below command in terminal
> **```mvn spring-boot:run```** it will run application as spring boot application

or
> **```mvn clean install```** it will build application and create **jar** file under target directory

Run jar file from below path with given command
> **```java -jar ~/path-to-spring-boot-mongodb/target/spring-boot-mongodb-0.0.1-SNAPSHOT.jar```**

Or
> run main method from `SpringBootMongoDBApplication.java` as spring boot application.


||
|  ---------    |
| **_Note_** : In `SpringBootMongoDBApplication.java` class we have autowired both SuperHero and Employee repositories. <br/>If there is no record present in DB for any one of that module class (Employee or SuperHero), static data is getting inserted in DB from `HelperUtil.java` class when we are starting the app for the first time.| 



### Code Snippets
1. #### Maven Dependencies
   Need to add below dependencies to enable Mongo related config in **pom.xml**. Lombok's dependency is to get rid of boiler-plate code.
    ```
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-mongodb</artifactId>
    </dependency>
   
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    ```

2. #### Properties file
   Reading Mongo DB related properties from **application.properties** file and configuring Mongo connection factory for mongoDB.

   **src/main/resources/application.properties**
     ```
    spring.data.mongodb.host=localhost
    spring.data.mongodb.port=27017
    spring.data.mongodb.database=spring_boot_mongo_app
    spring.jackson.default-property-inclusion=NON_NULL

     ```
   ### API Endpoints
- #### Authentication Operations
  > **Login api POST Mapping**  http://localhost:8081/api/v1/auth/login
  Request Body  
  ```
  {
    "username": "auth1",
    "password": 123456,
  }
  ```
  > **Register api POST Mapping**  http://localhost:8081/api/v1/auth/register
  Request Body
  ```
  {
    "username": "auth1",
    "password": 123456,
  }
  ```
  > **Logout api POST Mapping** ...
- #### Super Hero CRUD Operations
  > **GET Mapping** http://localhost:8081/api/v1/super-hero?pageIndex=2&pageSize=2  - Get all Super Heroes with pageIndex, pageSize

  > **GET Mapping** http://localhost:8081/api/v1/super-hero/5f380dece02f053eff29b986  - Get Super Hero by ID

  > **POST Mapping** http://localhost:8081/api/v1/super-hero  - Add new Super Hero in DB

      Request Body  
      ```
        {
            "name": "Tony",
            "superName": "Iron Man",
            "profession": "Business",
            "age": 50,
            "canFly": true
        }
      ```

  > **PUT Mapping** http://localhost:8081/api/v1/super-hero  - Update existing Super Hero for given ID

      Request Body  
      ```
        {
            "id": "5f380dece02f053eff29b986"
            "name": "Tony",
            "superName": "Iron Man",
            "profession": "Business",
            "age": 50,
            "canFly": true
        }
      ```

  > **DELETE Mapping** http://localhost:8081/api/v1/super-hero/5f380dece02f053eff29b986  - Delete Super Hero by ID
