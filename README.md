# backend-archetype
Maven archetype for backend projects with Spring, Hibernate and liquibase.

As you can see, this project is the base for all backend projects with java 1.8 and maven 3.6.3, but if you know how, its easy tu upgrade to the latest versions. This project has test too so, any code of you find here is tested to guarantee its correct operation.

## Structure of project

#### :file_folder: ***backend-archetype***:
* :file_folder: ***src***:
    * :file_folder: ***main***:
        * :file_folder: ***java***:
            * :file_folder: ***com.bytelius.backendarchetype***:
                * :file_folder: ***shared***: This folder contains the shared classes, and was intended to contain any shared code to reuse as many times as the developer deems necessary.
                    * :file_folder: ***exception***: This folder contains the exception classes.
                        * :page_facing_up: **`ErrorResponse.java`**:
                        * :page_facing_up: **`NotFoundException.java`**:
                        * :page_facing_up: **`NotValidArgumentException.java`**:
                        * :page_facing_up: **`WriteDBException.java`**:
                    * :file_folder: ***utils***: This folder contains the util classes.
                        * :page_facing_up: **`IUtilParser.java`**:
                    * :page_facing_up: **`URLConstant.java`**: Class containing all routes of the REST Api.
                    * :page_facing_up: **`GenericResponse.java`**: Base object that will return the backend to the client in JSON format.
                * :file_folder: ***city***:
                    * :file_folder: ***controller***: This folder contains any controller that api needs for city cases.
                        * :file_folder: ***impl***:
                            * :page_facing_up: **`CityController.java`**:
                        * :page_facing_up: **`ICityController.java`**:
                    * :file_folder: ***data***: This folder contains every class related with the mojo/pojo objects.
                        * :file_folder: ***dto***: It contains the mojo/pojo classes with you work. Inside it has two more folders for separate the full objects with the input/output objects. Because, you know, it is important to keep the information safe and not return unnecessary information to the user.
                            * :file_folder: ***input***: For any input object comes from user, here is where the java class should go. This classes only have the necessary attributes for api rest can manage the intel and send it to database.
                                * :page_facing_up: **`NewCityInput.java`**:
                                * :page_facing_up: **`UpdateCityInput.java`**:
                            * :file_folder: ***output***: For any output object for the user, this is where the java class should go. These classes only have the necessary attributes for the user to continue working in the application and have all the necessary information to do any type of action.
                                * :page_facing_up: **`CityOutput.java`**:
                                * :page_facing_up: **`NewCityOutput.java`**:
                                * :page_facing_up: **`UpdateCityOutput.java`**:
                            * :page_facing_up: **`CityClass.java`**: Full object that is equal to the entity, but without all the annotations to make these class resemble the database table.
                        * :file_folder: ***entity***: This contains the java classes who trying to be the database tables.
                            * :page_facing_up: **`CityEntity.java`**:
                        * :file_folder: ***mapper***: It contains the mappers to map each entity and mojo / pojo for any part of the code cannot throw any exceptions due to mismatches between the objects of the database, and the java objects that come from the client user.
                            * :page_facing_up: **`ICityMapper.java`**:
                    * :file_folder: ***repository***: This folder is for all repositories that you need for search, get, save or delete in the database.
                        * :file_folder: ***impl***:
                            * :page_facing_up: **`CityRepository.java`**:
                        * :page_facing_up: **`ICityRepository.java`**:
                    * :file_folder: ***service***: This folder contains all the java classes that are in charge of the business logic of the api. This is where it transforms the objects that the api receives into objects for the database, operate with them, and transform them again to return them.
                        * :file_folder: ***impl***: There are the interfaces which contains the code
                            * :page_facing_up: **`CityService.java`**:
                        * :page_facing_up: **`ICityService.java`**:
                * :file_folder: ***country***:
                    * :file_folder: ***controller***:
                    * :file_folder: ***data***:
                        * :file_folder: ***dto***:
                            * :page_facing_up: **`CountryClass.java`**: Full object that is equal to the entity, but without all the annotations to make these class resemble the database table.
                        * :file_folder: ***entity***:
                            * :file_folder: ***enums***:
                                * :page_facing_up: **`Continent.java`**:
                            * :page_facing_up: **`CountryEntity.java`**:
                        * :file_folder: ***mapper***:
                    * :file_folder: ***repository***:
                    * :file_folder: ***service***:
                * :page_facing_up: **`BackendArchetypeApplication.java`**: Main Java class. When you execute the server, this is the first java class runs.
                
        * :file_folder: ***resources***:
            * :file_folder: ***liquibase***: If you know about liquibase, I suppose you may know what's this folder contains and what for. If you don't know about it, go [here](https://www.liquibase.org/) and learn a bit. For the others, here are the files for manage a version control of your database.
                * :file_folder: ***changelog***:
                    * :file_folder: ***data***: Contains all the files with test information to do the tests necessary to verify that what you are developing works.
                        * :file_folder: ***sqlFiles***:
                          * :page_facing_up: **`world-data-v1.sql`**:
                        * :page_facing_up: **`db.changelog-data-v1.0.0.xml`**:
                    * :file_folder: ***ddl***: Contains all files with all ddl modifications to evolve the database in an orderly way.
                        * :page_facing_up: **`db.changelog-ddl-v1.0.0.xml`**:
                    * :page_facing_up: **`db.changelog-property-definition.xml`**: File containing all the common properties that the database attributes have.
                * :page_facing_up: **`db.changelog-master-integration.xml`**: Master file which is called and run every time that servers wake up. This file only contains to execute order of the other files.
            * :page_facing_up: **`application.properties`**: Property file which have the basic information for the connection to database, put the base url of api, liquibase configuration, set server port...
    * :file_folder: ***test***:
        * :file_folder: ***java***:
            * :file_folder: ***com.bytelius.backendarchetype***:
                * :file_folder: ***controller***:
                    * :file_folder: ***impl***:
                      * :page_facing_up: **`CityControllerTest.java`**:
                    * :page_facing_up: **`ICityControllerTest.java`**:
                * :file_folder: ***service***:
                  * :file_folder: ***impl***:
                      * :page_facing_up: **`CityServiceTest.java`**:
                  * :page_facing_up: **`ICityServiceTest.java`**:
                * :page_facing_up: **`BackendArchetypeApplicationTest.java`**:
* :page_facing_up: **`.gitignore`**:
* :page_facing_up: **`backend-archetype.iml`**:
* :page_facing_up: **`mvnw`**:
* :page_facing_up: **`mvnw.cmd`**:
* :page_facing_up: **`pom.xml`**: XML file that contains information about the project and configuration details used by Maven to build the project.
* :page_facing_up: **`README.md`**:

## How do we start?

For use this archetype, first you need change some application properties for run the project in your localhost.

So, before start you need to go to the **`application.properties`** file and change:

1) **spring.datasource.url**: Here you need to change the localhost url to connect the database. If you go to your database program (SQL Server Management, MySQL Workbench...) you can take the url connection from there.

2) **spring.datasource.username**: I recommend the super admin user, usually called *root* or *admin*

3) **spring.datasource.password**: *root* or *admin* password

4) **spring.session.jdbc.schema**: Put the name of your database with you'll go to work

5) (OPTIONAL) **spring.data.rest.basePath**: This is the base url for your api. This comes after the serverName:Port.
    - The url for this api starts localhost:8090/**spring.data.rest.base-path**/... so, if you want change it, you can change it in application.properties, and it will change in whole project.

After did this steps, execute a `mvn install` or `mvn build` lifecycle and start the server using a spring configuration.



## Comming updates for v2

1) Logging implementation using own configs and own exceptions
2) Docker implementation
3) Implementation of different users for different types of execution and different databases. (LOCAL - INT - PRE - PRO)
