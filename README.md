# JobMatch

[![Build Status](https://travis-ci.org/computerfr33k/JobMatch.svg?branch=master)](https://travis-ci.org/computerfr33k/JobMatch)

## Accessing the website
  * You can access the website when the server is running by going to `http://localhost:8080` which is the default host and port

## Running database migrations
  * In order to populate the database with the schema you will need to run the following command `mvn liquibase:update` in the jobmatch
folder where the pom.xml file is located.
  * The database file will be located in `./jobmatch/target`

## Building Jar
  * You can build a jar of the application by running `mvn package`