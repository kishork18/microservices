# Microservices Project

This repository contains a **microservices-based system** implemented in Java (Spring ecosystem).  
Each module represents an independent service with a specific responsibility, designed to be developed, deployed, and scaled independently.

---

## 🚀 Overview

This project demonstrates a **basic microservices architecture** with:

### 📌 Microservices Included
| Service                     | Purpose |
|----------------------------|---------|
| **ServiceRegistory**       | Service registry (Eureka / discovery server) — keeps track of all services |
| **Config-Server**          | Centralized configuration management |
| **ApiGateWay**             | API Gateway routing requests to underlying services |
| **UserService**            | Manages user-related data and logic |
| **HotelService**           | Handles hotel data and business logic |
| **RatingService**          | Provides ratings data, potentially for hotels/users |

---

## 🧠 Architecture

This system applies a microservices architecture with the following principles:

- Each service runs independently
- Configuration is centralized via the Config Server
- Services discover one another using a Service Registry
- API Gateway routes and protects entry points

## 🧠 Architecture

```mermaid
flowchart TD
    Client[Client / Frontend] -->|HTTP Requests| APIGateway[API Gateway]

    APIGateway --> UserService[User Service]
    APIGateway --> HotelService[Hotel Service]
    APIGateway --> RatingService[Rating Service]

    UserService --> ServiceRegistry[Service Registry]
    HotelService --> ServiceRegistry
    RatingService --> ServiceRegistry
    APIGateway --> ServiceRegistry

    ConfigServer[Config Server] --> UserService
    ConfigServer --> HotelService
    ConfigServer --> RatingService
    ConfigServer --> APIGateway


---

## 🛠️ Prerequisites

Before you start, make sure you have:

- **Java 17+**
- **Maven 3.6+**
- **Docker & Docker Compose** (optional, but highly recommended)
- Environment variables configured for each service if needed

---

## 📦 Setup & Running Locally

### 1. Clone the repository
```sh
git clone https://github.com/kishork18/microservices.git
cd microservices
