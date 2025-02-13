# Client CRUD - Spring Boot

## 🚀 Project Overview
This project is a **RESTful API** built with **Spring Boot** to manage clients, implementing the following operations:

- **Paginated retrieval** of clients.
- **Find client by ID**.
- **Insert a new client**.
- **Update an existing client**.
- **Delete a client**.

The project uses an **H2 database** for testing, **Maven** as the dependency manager, and follows best practices for exception handling.

---

## 🛠️ Technologies
- **Java 21**
- **Spring Boot 3.3.8**
- **Spring Data JPA**
- **H2 Database** (Testing environment)
- **Maven**
- **Bean Validation**


## 🛡️ Exception Handling

| Scenario | HTTP Code | Response |
|----------|----------|----------|
| Client not found | `404 Not Found` | `{ "error": "Client not found" }` |
| Empty name | `422 Unprocessable Entity` | `{ "error": "Name cannot be empty" }` |
| Future birth date | `422 Unprocessable Entity` | `{ "error": "Birth date must be in the past or present" }` |

