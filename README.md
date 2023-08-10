## Requirements

For building and running the application you need:

- [JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [Maven 3](https://maven.apache.org)


## Running the application

Install the maven dependencies
```shell
mvn install
```

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `io.marktoledo.exchangerateapi.ExchangeRateApiApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```


## Running the unit test
```shell
mvn test
```

## API Documentation

- [Swagger UI](http://localhost:8080/swagger-ui/index.html)

- [Open API](http://localhost:8080/v3/api-docs)

## Documentation

1.  The API key for the 3rd-party API was located in application.yml
2.  The API key has limitations, ex. The base only allows the use of EUR
3.  All errors in the 3rd-party API response were only forwarded to the Rest Controller response.


