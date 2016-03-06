# Spring Boot 1.3 project

## Initialize

Spring Boot needs [Maven 3.2 or above](https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started-installing-spring-boot.html)

Created using http://start.spring.io/
Selected starters: Web, Security, DevTools, Session, REST Docs, Rest Repositories, JPA, Actuator

## Controllers
[Hypermedia-Driven RESTful Web Service](https://spring.io/guides/gs/rest-hateoas/)

## Liquibase
Spring Boot [Database initialization](https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html)
Spring Boot [Liquibase Sample](https://github.com/spring-projects/spring-boot/tree/v1.3.2.RELEASE/spring-boot-samples/spring-boot-sample-liquibase)
* http//localhost:8080/h2-console
* default jdbc url is jdbc:h2:mem:testdb

## Accessing Data REST
[Tutorial](https://spring.io/guides/gs/accessing-data-rest/)

## Environments configuration
* [Set the active profile](https://docs.spring.io/spring-boot/docs/current/reference/html/howto-properties-and-configuration.html#howto-set-active-spring-profiles)
** export SPRING_PROFILES_ACTIVE=prod 
* [Profile specific properties](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html#boot-features-external-config-profile-specific-properties) file
** Format for properties file name: application-{env}.properties where {env} is the database name
* default database is H2

## Databases
### H2
* Driver Class: org.h2.Driver
* Url: jdbc:h2:mem:testdb
* user name: sa
* pw:
### HSQLDB
* Driver Class: org.hsqldb.jdbcDriver
* Url: jdbc:hsqldb:mem:testdb;hsqldb.default_table_type=cached
* user name: sa
* pw:

## References
* [Spring Booot common application properties](https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)
