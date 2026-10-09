# Temperature Converter - OTP In-class Assignment

## 1. Assignment Description
The objective of these assignments is to develope and improve a Java-based temperature converter application using software development, testing, and database.

The application performs temperature conversions between Celsius, Fahrenheit, and Kelvin. The project was extended by introducing a graphical user interface (GUI) and database integration. 

Main requirements:
- Implement temperature conversion functionality with Java
- Create a MariaDB database
- Connect the Java application to the database using JDBC (Java Database Connectivity)
- Organize database operations using DAO classes
- Write unit tests to verify the application's functionality
- Configure JaCoCo to generate code coverage reports
- Create a Jenkins pipeline for automatic building and testing
- Create a Docker image, run the application locally and within Docker, and deploy the image to Docker Hub
- Verify the application using XMing

## 2. Technologies and Tools Used

| Technology/Tool | Purpose |
| ------------- | ------------- |
| Java | Application logic and temperature conversion |
| Maven | Dependency management and project building |
| JUnit | Automated unit testing |
| JaCoCo | Code coverage reports |
| IntelliJ IDEA | Development environment |
| GitHub | Version control |
| Jenkins | Automated pipeline |
| Docker | Application containerization |
| Docker Hub | Docker image hosting |
| MariaDB | Database management |
| HeidiSQL | Database administration and SQL queries |
| JDBC | Communication between MariaDB and Java |
| XMing | Displaying graphical applications from a containerized environment |

## 3. Design Approach and Implementation Method

### Application Design
The application uses Java to implement the temperature conversion logic. The conversion functionality is kept separate from the application's entry point to make the code easier to maintain and test.

The original implementation includes these methods:
- Fahrenheit to Celsius
- Celsius to Fahrenheit
- Kelvin to Celsius
- Checking for extreme temperatures

The planned JavaFX interface will allow users to enter a temperature, select the relevant units, perform a conversion, and view the result.

### Database Design

MariaDB is used as the database, and HeidiSQL is used to create and inspect the database and its tables.

The database structure consists of two related tables: 

`temperature_unit`, which stores temperature units.
| Column | Description |
| ------------- | ------------- |
| id | primary key |
| name | unit name |
| symbol | unit symbol |

and `temp_record`, which stores temperature conversion records
| Column | Description |
| ------------- | ------------- |
| id | primary key | 
| value | original temperature |
| converted_value | converted temperature |
| from_unit_id | foreign key referencing temperature_unit.id |
| to_unit_id | foreign key referencing temperature_unit.id |
| created_at | date and time of the conversion |

### Database Access

The Java application will use JDBC to connect to MariaDB.

Database operations will be separated into dedicated classes:

- DBConnection — establishes database connections
- TemperatureUnit — represents a temperature unit
- TemperatureUnitDAO — retrieves and manages temperature units
- TempRecord — represents a conversion record
- TempRecordDAO — saves and retrieves conversion records

This approach separates database operations from the user interface and conversion logic.

### Build and Deployment

Maven manages the project's dependencies and build lifecycle. JUnit tests are executed during the build, and JaCoCo generates code coverage reports.

The Jenkinsfile defines a pipeline for checking out the source code, building the application, running tests, and generating coverage reports. Docker is used to package the application into an image, which can be tested locally and published to Docker Hub.

## 4. Testing and Quality Assurance

### Automated Tests

JUnit 5 is used to test the temperature conversion functionality.

| Test scenario	| Expected result |
| ------------- | ------------- |
| Fahrenheit to Celsius	| Correct converted temperature |
| Celsius to Fahrenheit	| Correct converted temperature |
| Kelvin to Celsius	| Correct converted temperature |
| Extreme temperature check | Correct classification according to the defined threshold |

### Manual Testing

Manual verification includes the following steps:

- Run the application from IntelliJ IDEA.
- Enter temperature values and verify the conversion results.
- Verify that invalid inputs are handled appropriately.
- Check the database and its tables using HeidiSQL.
- Verify that conversion records can be saved and retrieved once database integration is complete.
- Build and run the Docker image locally.
- Verify the graphical interface through Xming or another compatible X server.
- Check the Jenkins pipeline execution and the generated JaCoCo report.
- Verify the published image on Docker Hub.

### Running Automated Tests 

Execute the following Maven command from the project root:

`mvn clean test`

To generate the JaCoCo report, run:

`mvn jacoco:report`

The coverage report is available at 

`target/site/jacoco/index.html`

## 5. How to Run

### Prerequisites
- IntelliJ IDEA or another Java IDE
- JDK compatible with the project's Maven configuration
- Apache Maven
- MariaDB and HeidiSQL
- Docker Desktop
- Jenkins
- XMing or another compatible X server

### Clone the repository

Open a terminal and execute:

`git clone https://github.com/oliviatoratti/OTP-inclass1-assignment-.git cd OTP-inclass1-assignment-`

Or clone the repository directly from IntelliJ IDEA.

### Build the Project

From the project root, run:

`mvn clean package`

This compiles the application, executes the configured tests, and packages the project if the build succeeds.

### Run the Application

Open the project in IntelliJ IDEA, allow Maven to download the required dependencies, and run the application's `Main` class.

For the JavaFX version, ensure that the JavaFX dependencies and configuration are set up correctly.

### Configure the Database
1. Start MariaDB server
2. Open HeidiSQL and connect to the server
3. Create the application database
4. Create the temperature_unit and temp_record tables with the required foreign keys
5. Configure the JDBC connection URL, username, and password in the application

### Build and Run Docker

After configuring the Dockerfile and successfully building the application, execute:

`docker build -t temperature-converter .`

Run the image using:

`docker run --rm temperature-converter`

### Jenkins Pipeline

Configure a Jenkins pipeline project using the GitHub repository URL and set the script path to: `Jenkinsfile`

Run the pipeline and verify the build, tests, and code coverage stages. Once Docker Hub credentials and deployment stages are configured, verify that the image is successfully published.
