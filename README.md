# MovieList

A simple movie ticket booking application using Angular and Spring Boot


### Key features
Funcational
 - List of featured movies
 - List of theatres currently playing the requested movie
 - Booking tickets
 - Confirmation
 
Technical
 - Secured Rest API's using JWT token based authentication.
 - Documentation of API's using swagger.
 - Integration and unit tests covering functionalities.

### Technologies used
 - Spring Boot
 - Angular
 - JWT
 - Spring JPA
 - H2 Database
 - Springfox and Swagger

###Running Movie Finder locally

###Backend

Prerequisites
Backend
Java 8+
git command line tool (https://help.github.com/articles/set-up-git)
Maven
Your prefered IDE (Eclipse,STS or IntelliJ )
Steps:
- Clone the project from git clone https://github.com/vspanchagnula/movie-finder.git

- To run using an IDE (Intellij): From the main menu, choose File->Open and navigate to the movieapp folder cloned from previous step Right click MovieBookingApplication class file and choose Run

The application can then be accessed by pointing your browser to http://localhost:8080 

- Api spec can be accessed via swagger-ui http://localhost:8080/swagger-ui.html


- The application can also be run as a docker image. To run as a docker image (docker needs to be preinstalled):
- Integration/unit tests are run as part of the build. If you want to run an individual test you could run them as junit tests

###Frontend
Angular 
git command line tool (https://help.github.com/articles/set-up-git)
Node > version 8
Your prefered IDE (Visual Studio Code or Webstorm)
This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 7.0.4.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

