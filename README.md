
# 🍎 Fruit REST API - Sprint 4 Task 2 Level 1

A Spring Boot CRUD REST API to manage fruit entries.  
Built with modern practices: DTOs using Java `record`, Bean Validation, global exception handling, and an in-memory H2 database.

---

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot 3**
- **Spring Data JPA (Hibernate)**
- **H2 in-memory database**
- **Lombok**
- **Bean Validation (Jakarta Validation)**
- **Global Exception Handling with `@RestControllerAdvice`**
- **JUnit 5 & MockMvc** (for testing)

---

## 🚀 API Endpoints

Base URL: `/api/fruits`

### ➕ Create Fruit
**POST** `/api/fruits`

**Request Body:**
```json
{
  "name": "Banana",
  "quantityKilos": 10
}
```

**Response (201 Created):**
```json
{
  "id": 1,
  "name": "Banana",
  "quantityKilos": 10
}
```
Header: `Location: http://localhost:8080/api/fruits/1`

---

### 📋 Get All Fruits
**GET** `/api/fruits`

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "name": "Banana",
    "quantityKilos": 10
  },
  {
    "id": 2,
    "name": "Apple",
    "quantityKilos": 5
  }
]
```

---

### 🔍 Get Fruit by ID
**GET** `/api/fruits/{id}`

**Response (200 OK):**
```json
{
  "id": 1,
  "name": "Banana",
  "quantityKilos": 10
}
```

---

### ✏️ Update Fruit
**PUT** `/api/fruits/{id}`

**Request Body:**
```json
{
  "name": "Pear",
  "quantityKilos": 15
}
```

**Response (200 OK):**
```json
{
  "id": 1,
  "name": "Pear",
  "quantityKilos": 15
}
```

---

### 🗑️ Delete Fruit
**DELETE** `/api/fruits/{id}`

**Response (204 No Content):**  
_No body returned._

---

## 🛑 Error Handling

This API includes a global exception handler (`GlobalExceptionHandler`) returning consistent JSON errors.

### Common Error Responses

| HTTP Status | Error                 | Example Response |
|-------------|-----------------------|------------------|
| `400`       | Validation Error / Bad Request | ```json { "status":400,"error":"Validation Error","message":"Invalid request data","errors":["quantityKilos: Quantity must be at least 1 Kg"] } ``` |
| `404`       | Not Found             | ```json { "status":404,"error":"Not Found","message":"Fruit not found with id: 99","path":"/api/fruits/99" } ``` |
| `409`       | Data Conflict (duplicate name) | ```json { "status":409,"error":"Data Conflict","message":"The resource already exists or violates a data constraint" } ``` |
| `500`       | Internal Server Error | ```json { "status":500,"error":"Internal Server Error","message":"An unexpected error occurred" } ``` |

---

### Example Validation Error

**POST** `/api/fruits` with invalid body:
```json
{
  "name": "",
  "quantityKilos": -5
}
```

**Response (400 Bad Request):**
```json
{
  "timestamp": "2025-10-01T12:00:00Z",
  "status": 400,
  "error": "Validation Error",
  "message": "Invalid request data",
  "path": "/api/fruits",
  "errors": [
    "name: Name is required",
    "quantityKilos: Quantity must be at least 1 Kg"
  ]
}
```

---

## 🧪 H2 Console

Access the in-memory H2 console at:

- URL: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- JDBC URL: `jdbc:h2:mem:fruitdb`
- Username: `sa`
- Password: *(empty)*

---

## ▶️ Running the Project

1. Clone repository & unzip project
2. Run with Maven:
   ```bash
   mvn spring-boot:run
   ```
3. Access API at: [http://localhost:8080/api/fruits](http://localhost:8080/api/fruits)

---

## ✅ Testing

The project includes unit and integration tests with **JUnit 5** and **MockMvc**.  
Run tests with:

```bash
mvn test
```
