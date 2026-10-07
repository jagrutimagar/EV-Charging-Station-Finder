# EV Charging Station Finder

A lightweight Java EE web application for locating EV charging stations, registering users, and booking charging slots.

## Features

- User registration and login
- Browse available charging stations
- Book charging slots
- View booking dashboard
- In-memory data store for quick setup and demonstration

## Tech Stack

- Java 17
- Maven
- Jakarta Servlet API
- JSP + CSS

## Run locally

1. Ensure Maven is installed.
2. From the project root, run:
   mvn package
3. Deploy the generated WAR file in a servlet container such as Tomcat.
4. Open the app in a browser and visit:
   http://localhost:8080/evchargingstationfinder/

## Project structure

- src/main/java/com/evcharging/controller
- src/main/java/com/evcharging/dao
- src/main/java/com/evcharging/model
- src/main/java/com/evcharging/util
- src/main/webapp
