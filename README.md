# 🚌 Smart Public Transport Tracker

A backend service built with **Java + Spring Boot** to simulate and manage real-time public transportation—track buses, predict ETAs using Dijkstra's algorithm, and expose clean APIs for frontend or mobile clients.

---

## 🚀 Features

- 📍 Simulated live bus location updates
- 🧭 ETA prediction using Dijkstra’s algorithm
- 🗺️ Search nearest bus stops based on user location
- 🛠️ Admin APIs to manage buses, routes, and schedules
- 🔄 WebSocket or polling support for real-time updates
- 🧪 RESTful APIs with Swagger UI for testing

---

## ⚙️ Tech Stack

| Layer         | Technology                        |
|---------------|------------------------------------|
| Language      | Java 17                            |
| Framework     | Spring Boot (Web, JPA, Scheduling) |
| Database      | MySQL or PostgreSQL                |
| API Docs      | Springdoc OpenAPI (Swagger)        |
| Realtime      | WebSocket / Kafka (optional)       |
| Geolocation   | Haversine formula (distance calc)  |
| Build Tool    | Maven                              |
| Deployment    | Docker + GitHub Actions (CI/CD)    |

---

## 🧱 Modules

| Module         | Description                                     |
|----------------|-------------------------------------------------|
| `Bus`          | Holds info like bus ID, current location, route |
| `Route`        | Contains sequence of bus stops                  |
| `BusStop`      | Geo-coordinates and metadata of each stop       |
| `ETA Service`  | Calculates ETA using Dijkstra's algorithm       |
| `Simulation`   | Scheduled task to simulate GPS updates          |

---

## 📦 API Endpoints (User)

- `GET /buses?from=A&to=B` — Find available buses between two locations  
- `GET /eta?route=R1&from=A&to=B` — Get estimated time of arrival  
- `GET /bus-stops/nearby?lat=..&lng=..` — Find nearest bus stops

### 🛠 Admin APIs

- `POST /routes` — Add/update a route  
- `POST /buses` — Register/simulate a bus  
- `PUT /schedule/{id}` — Update schedule

---

## 🧪 Setup & Run Locally

### 1. Clone the Repo

```bash
git clone https://github.com/vishalnpasi/transport-tracker.git
cd transport-tracker
