# weather-app-kotlin

This is a SpringBoot and Kotlin project with a simple REST service to retrieve weather forecast from the following webservce.
https://api.weather.gov/gridpoints/MLB/33,70/forecast

## Prerequisites
- Java Development Kit (JDK) 17 or later
- Gradle build tool (version 8.2)
- An internet connection to fetch project dependencies

## Build
To build the project, use Gradle:
```sh
./gradlew build
```

## Running the Project
To start the application, run the following command:
```sh
./gradlew bootRun
```

## Example Usage
You can make a API request as follows:
```sh
curl http://localhost:8080/weather/current
```

