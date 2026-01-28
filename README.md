
# 🏨 Hotel Management System – Backend (Spring Boot)

A **backend-only Hotel Management System** built using **Spring Boot** and **RESTful APIs**.
This project provides APIs to manage hotels, rooms, bookings, and customers, designed to be easily consumed by any frontend or mobile application.

## 🚀 Features

* Hotel management (add, update, view hotels)
* Room management (room types, availability, pricing)
* Booking management (create, update, cancel bookings)
* Customer management
* RESTful API architecture
* Clean layered structure (Controller → Service → Repository)
* JSON-based request & response handling

## 🛠 Tech Stack

* **Java**
* **Spring Boot**
* **Spring Web (REST APIs)**
* **Spring Data JPA**
* **Hibernate**
* **MySQL / PostgreSQL** (configurable)
* **Maven**
* **JSON**

## 📐 Project Architecture

```
Controller Layer  -> Handles API requests
Service Layer     -> Business logic
Repository Layer  -> Database operations
Entity Layer      -> Database models
```

## 📌 API Endpoints (Sample)

### 🏨 Hotel APIs

```http
POST   /api/hotels
GET    /api/hotels
GET    /api/hotels/{id}
PUT    /api/hotels/{id}
DELETE /api/hotels/{id}
```

### 🛏 Room APIs

```http
POST   /api/rooms
GET    /api/rooms
GET    /api/rooms/{id}
GET    /api/rooms/hotel/{hotelId}
PUT    /api/rooms/{id}
DELETE /api/rooms/{id}
```

### 📅 Booking APIs

```http
POST   /api/bookings
GET    /api/bookings
GET    /api/bookings/{id}
PUT    /api/bookings/{id}
DELETE /api/bookings/{id}
```

### 👤 Customer APIs

```http
POST   /api/customers
GET    /api/customers
GET    /api/customers/{id}
PUT    /api/customers/{id}
DELETE /api/customers/{id}
```

## ⚙️ How to Run the Project

1. Clone the repository

```bash
git clone https://github.com/your-username/hotel-management-system.git
```

2. Navigate to the project directory

```bash
cd hotel-management-system
```

3. Configure database in `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hotel_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

4. Run the application

```bash
mvn spring-boot:run
```

5. Base URL

```text
http://localhost:8080/api
```

## 🧪 API Testing

* Tested using **Postman**
* Supports JSON request and response
* Easily integratable with frontend frameworks (React, Angular, Flutter)

## 🔒 Security (Future Scope)

* Spring Security & JWT authentication
* Role-based access (Admin, Staff, Customer)

## 🔮 Future Enhancements

* Payment gateway integration
* Room availability optimization
* Booking conflict prevention
* Email/SMS notifications
* Admin dashboard support
* Microservices migration

## 👨‍💻 Author

**Avanish Pratap Singh**
Java | Spring Boot | Backend Developer

