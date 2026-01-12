# URL Shortener (Spring Boot + MySQL)

A backend URL Shortener application built using Spring Boot, JPA, and MySQL.
This project demonstrates real-world backend development practices used in product-based companies.

---

## Features
- Shorten long URLs
- Redirect short URLs to original URLs
- Base62 encoding for short links
- Duplicate URL handling
- URL expiry support
- Click count tracking
- DTO validation
- Global exception handling
- Swagger API documentation

---

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Hibernate
- Maven
- Swagger (OpenAPI)
- Lombok

---

## API Endpoints

### Shorten URL
POST /api/shorten

Request:
{
  "originalUrl": "https://www.linkedin.com/in/pavanjagadeesh"
}

Response:
{
  "shortUrl":"http://localhost:8080/{shortCode}"
}

---

### Redirect URL
GET /{shortCode}

Example (when app is running locally):
http://localhost:8080/{shortCode}


---

## Swagger UI
http://localhost:8080/swagger-ui/index.html

---

## How to Run
1. Create database:
CREATE DATABASE url_shortener_db;

2. Update application.properties with DB credentials

3. Run:
mvn spring-boot:run

---

## Author
Pavan Jagadeesh  
LinkedIn: https://www.linkedin.com/in/pavanjagadeesh
