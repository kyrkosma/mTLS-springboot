## About The Project

A springboot app demonstrating how to set up mTLS.

Server URL: https://client.badssl.com/

## Getting Started

### Dependencies

* Java 17
* Maven 3.9.9
* Using your browser, export certificate of https://client.badssl.com/ and add it to %JAVA_HOME%\lib\security\cacerts

## How to run the application

* Download the project
* Unzip it
* Open terminal in the folder created
* Run:
```
cd .\mTLS-springboot-main\

mvn spring-boot:run
```
* Open browser and navigate to https://localhost:8080/