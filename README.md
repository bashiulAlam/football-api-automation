# API Automation Task #

This project automates a couple of APIs hosted in [Football API Collection](https://www.football-data.org/)
***

## Project Tools Used
- **Programming Language:** Groovy (Version 2.4.4), Java (JDK 1.8)
- **Framework and Tools Used:** Spock, REST Assured (Version 3.0.0), Gradle, Log4j Logging
- **IDE:** Intellij Idea
 
## Project Structure

- The project is implemented with *Spock* framework with support of *BDD* format test cases which have been implemented in a class file under: *{project_root}/src/test/groovy/com/assignment/endtoendtest/specification/*
- The API clients have been implemented in a class file under: *{project_root}/src/test/groovy/com/assignment/endtoendtest/helper/*
- A properties file have been added to *resources* folder for ease of use of access variables
- We also have an *utils* package to maintain the configuration variables, constant values and utility methods
 
## Prerequisites

- You need to have the following installations in your machine:
    - JDK
    - Gradle
    - Any IDE of your choice that supports Java and Groovy
- A browser of your choice to check the HTML report
- A text editor tool of your choice to check the logs
- For windows machine, you will need the following added to your system environment variables:
    - JDK
    - Gradle

## Project Import
1. Clone the project from GitHub or download the project and unzip it
2. Open your IDE and import the project as a *Gradle* project

## Before You Run
- Open the **config.properties** file from the path: *src/main/resources* and set the required variables here:
    1. Set the API key of your account registered with the API provider

## How to Run
- You can run the project from your IDE by following the steps:
    1. Open the groovy class **APITestSpec.groovy** from the path: *src/test/groovy/com/assignment/endtoendtest/specification/*
    2. Run this class
- You can run the project from command prompt or terminal by executing the following command from your *{project_root}*:

         ./gradlew test

## Report and Logging
1. If you run the project from your IDE you can see the results from your IDE console
2. As we are using *gradle* we will have an HTML report generated after every run which can be found here: *{project_root}/build/reports/tests/test/index.html*`
3. We have logging enabled for better visualization and ease of troubleshooting in case of any error. Log file can be found here: *{project_root}/log*
 
## Future Improvements

1. Add more API support
2. Add project with a CI/CD pipeline 
