# 🏨 API REST – Gestión de Hoteles

API REST desarrollada con **Spring Boot** para gestionar hoteles y sus habitaciones. Incluye creación de hoteles, registro de habitaciones y consultas filtradas.

## 🚀 Tecnologías
- Java 17
- Spring Boot (Web, Data JPA)
- Lombok
- H2/MySQL

## 🔧 Funcionalidades
- Crear hoteles
- Crear habitaciones dentro de un hotel
- Listar hoteles
- Listar habitaciones de un hotel
- Buscar habitaciones con filtros por tamaño y precio

## 📌 Ejemplos de Endpoints
**Crear hotel**  
`POST /hoteles`

**Crear habitación**  
`POST /habitaciones/{codigoHotel}`

**Buscar habitaciones**  
`GET /habitaciones/{codigoHotel}/buscar?tamanoMinimo=20&precioMinimo=50&precioMaximo=100`

## 📁 Estructura
Controllers • Services • Repositories • Entities • DTOs

---

