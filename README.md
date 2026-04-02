# Finance Dashboard Backend

A RESTful backend service for managing financial records with role-based access control and dashboard analytics.

## Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- H2 In-Memory Database
- Swagger (OpenAPI)
- Maven

## Features
- User and Role Management (ADMIN, ANALYST, VIEWER)
- Financial Records CRUD operations
- Record filtering by type and category
- Dashboard summary (total income, total expense, net balance)
- Role-based access control
- Global exception handling
- Swagger API documentation

## Roles
- ADMIN: Full access (create, update, delete)
- ANALYST: Read access and dashboard analytics
- VIEWER: Read-only access

## How to Run
Clone the repository and run:


Swagger available locally at:
http://localhost:8080/swagger-ui/index.html