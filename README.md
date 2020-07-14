# backend-archetype
Maven archetype for backend projects with Spring, Hibernate, Docker

As you can see, this project is the base for all backend projects with latest tech as possible. This project has test too so, any code of you find here is tested to guarantee its correct operation.

## Structure of project

#### :file_folder: ***backend-archetype***:
* :file_folder: ***src***:
    * :file_folder: ***main***:
        * :file_folder: ***java***:
            * :file_folder: ***com.brickncode.backendarchetype***:
                * :file_folder: ***common***: This folder contains the common classes, and was intended to contain any common code to reuse as many times as the developer deems necessary.
                    * :file_folder: ***utils***: This folder contains the util classes.
                        * :page_facing_up: **`Parsers.java`**:
                    * :page_facing_up: **`GenericResponse.java`**: Base object that will return the backend to the client in JSON format.
                    * :page_facing_up: **`URLConstant.java`**: Class containing all routes of the REST Api.
                * :file_folder: ***controller***: This folder contains any controller that api needs.
                    * :page_facing_up: **`ExampleController.java`**: Example of a controller with all api REST methods. GET, POST, PUT, DELETE.
                * :file_folder: ***data***: This folder contains every class related with the mojo/pojo objects.
                    * :file_folder: ***entity***: This contains the java classes who trying to be the database tables.
                        * :page_facing_up: **`AuditableEntity.java`**: Father entity that contains the database user intel.
                        * :page_facing_up: **`ExampleEntity.java`**:
                    * :file_folder: ***mapper***: It contains the mappers to map each entity and mojo / pojo for any part of the code cannot throw any exceptions due to mismatches between the objects of the database and the java objects that come from the client user.
                        * :page_facing_up: **`ExampleMapper.java`**:
                    * :file_folder: ***model***: It contains the mojo/pojo clases with you work. Inside it has two more folders for separate the full objects with the input/output objects. Because, you know, it is important to keep the information safe and not return unnecessary information to the user.
                        * :file_folder: ***input***: For any input object comes from user, here is where the java class should go. This classes only have the necessary attributes for api rest can manage the intel and send it to database.
                            * :page_facing_up: **`ExampleGetInput.java`**:
                            * :page_facing_up: **`ExamplePostInput.java`**:
                            * :page_facing_up: **`ExamplePutInput.java`**:
                        * :file_folder: ***output***: For any output object for the user, this is where the java class should go. These classes only have the necessary attributes for the user to continue working in the application and have all the necessary information to do any type of action.
                            * :page_facing_up: **`ExampleGetOutput.java`**:
                            * :page_facing_up: **`ExamplePostOutput.java`**:
                            * :page_facing_up: **`ExamplePutOutput.java`**:
                        * :page_facing_up: **`Example.java`**: Full object that is equal to the entity, but without all the annotations to make this class resemble the database table.
                * :file_folder: ***repository***: This folder is for all repositories that you need for search, get, save or delete in database.
                    * :page_facing_up: **`ExampleRepository.java`**:
                * :file_folder: ***service***: This folder contains all the java classes that are in charge of the business logic of the api. This is where it transforms the objects that the api receives into objects for the database, operate with them, and transform them again to return them
                    * :file_folder: ***interfaces***: There is the interfaces which contains the code
                        * :page_facing_up: **`ExampleService.java`**:
                    * :page_facing_up: **`ExampleServiceImpl.java`**: This is only the implementation
                * :page_facing_up: **`BackendArchetypeApplication.java`**: Main Java class. When you execute the server, this is the first java class that runs.
        * :file_folder: ***resources***:
            * :file_folder: ***liquibase***: If you know abaout liquibase, I supose you may know whats this folder contains and what for. If you don't know about it, go [here](https://www.liquibase.org/) an learn a bit. For the others, here are the files for manage a version control of your database.
                * :file_folder: ***changelog***:
                    * :file_folder: ***data***: Contains all the files with test information to do the tests necessary to verify that what you are developing works.
                        * :page_facing_up: **`db.changelog-data-v1.0.0.xml`**:
                    * :file_folder: ***ddl***: Contains all files with all ddl modifications to evolve the database in an orderly way.
                        * :page_facing_up: **`db.changelog-ddl-v1.0.0.xml`**:
                    * :page_facing_up: **`db.changelog-property-definition.xml`**: File containing all the common properties that the database attributes have.
                * :page_facing_up: **`db.changelog-master-integration.xml`**: Master file which is called and run every time that servers wake up. This file only contains the execute order of the other files.
            * :file_folder: ***static***:
            * :file_folder: ***templates***:
            * :page_facing_up: **`application.properties`**: Property file which have the basic information for the connection to database, put the base url of api, liquibase configuration, set server port...
    * :file_folder: ***test***:
        * :file_folder: ***java***:
            * :file_folder: ***com.brickncode.backendarchetype***:
                * :file_folder: ***controller***:
                    * :page_facing_up: **`ExampleControllerTest.java`**:
                * :file_folder: ***repository***:
                    * :page_facing_up: **`ExampleRepositoryTest.java`**:
                * :file_folder: ***service***:
                    * :file_folder: ***interfaces***:
                        * :page_facing_up: **`ExampleServiceTest.java`**:
                    * :page_facing_up: **`ExampleServiceImplTest.java`**:
                * :page_facing_up: **`BackendArchetypeApplicationTest.java`**:
* :page_facing_up: **`.gitignore`**:
* :page_facing_up: **`backend-archetype.iml`**:
* :page_facing_up: **`mvnw`**:
* :page_facing_up: **`mvnw.cmd`**:
* :page_facing_up: **`pom.xml`**: XML file that contains information about the project and configuration details used by Maven to build the project.
* :page_facing_up: **`README.md`**:

## How do we get start?

For use this archetype, first you need change some application properties for run the project in your localhost.

So, before start you need to go to the application.properties file which is located at 'src/main/resources' path and change:

1) spring.datasource.url
Here you need to change the localhost url to connect database. If you go to your database program (SQL Server Management, MySQL Workbench...) you can take the url connection from there.
2) spring.datasource.username
   spring.datasource.password
   You need put your user and password of your database. Usually, the root/admin user.
3) spring.session.jdbc.schema
Put the name of your database with you'll go to work

