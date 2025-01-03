# Java Redis Integration

## Overview
This project demonstrates how to integrate a Java application with Redis to leverage caching capabilities and improve data-fetching performance. The application uses **Spring Boot** to manage the lifecycle of the application and **Redis** as the caching layer for optimized read and write operations.

---

## Features
- **CRUD Operations**: Create, Read, Update, and Delete invoices.
- **Caching**: Use Redis as a caching layer to minimize database hits.
- **Thread Safety**: Ensures safe handling of cached data in concurrent environments.
- **Exception Handling**: Properly handles cases where records are not found.

---

## Technologies Used
- **Java**: Core language.
- **Spring Boot**: Framework for building the application.
- **Redis**: Caching database.
- **Maven**: Dependency and build management.
- **Lombok**: To reduce boilerplate code in Java (e.g., `@Getter`, `@Setter`).

---

## Prerequisites
- **JDK** 11 or higher
- **Maven** 3.6+
- **Redis Server** running on `localhost:6379`
- IDE of your choice (e.g., IntelliJ IDEA, Eclipse)

---

## Setup Instructions

### Clone the Repository
```bash
git clone https://github.com/your-username/Java_Redis_Integration.git
cd Java_Redis_Integration
