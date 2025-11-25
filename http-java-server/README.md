# HTTP Server Lab (Java)

Final-year **Distributed Systems** lab exercise implemented in Java.  
A simple **multi-threaded HTTP server** using `com.sun.net.httpserver` with two endpoints:

- `GET /status` → health check (`"Server is alive\n"`)
- `POST /task`  → multiplies a comma-separated list of integers and returns the product

---

## Context

This was completed as a **college lab** on a **university VM** (Azure Lab Services) using **IntelliJ IDEA**.  
It was **originally hosted on my college GitHub Classroom repo**; I’m now **submitting the source to my personal GitHub** for portfolio/reference. (Only my own lab solution is included.)

---

## Requirements

- **JDK 11+** (Temurin recommended)
- Terminal with **cURL** for testing
