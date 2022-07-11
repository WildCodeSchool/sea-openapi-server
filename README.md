### OpenAPI Server

This Maven project hosts the Spring Boot OpenAPI Java REST service for the [REST client stubs](https://github.com/WildCodeSchool/sea-openapi-client/).

### Prerequisites

* Java 11+
* Maven 3+

### Setup

* Clone repository.
* Run Maven `clean install`.

### Run

* Start `SpringWithRestApplication`

### Open generated OpenAPI/Swagger UI

* Open http://localhost:8080/swagger-ui/index.html for Swagger-UI
* Open http://localhost:8080/v3/api-docs for OpenAPI JSON

### In-Memory Database Administration

This demo uses an in-memory h2 database with URL `jdbc:h2:mem:oapi`.  
A h2-console is deployed at http://localhost:8080/h2-console for simple database management, connect with `jdbc:h2:mem:oapi`, username "sa", no password

![](https://i.imgur.com/ImsLZoxm.png)