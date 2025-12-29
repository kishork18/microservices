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

*(Add a diagram here if available — this helps communicate structure visually.)*

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
