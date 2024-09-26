# API REST Finalizada

Este proyecto es una **API REST** desarrollada utilizando el framework **Spring Boot**. La aplicación permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre entidades gestionadas a través de **JPA (Java Persistence API)**, y utiliza una base de datos en memoria **H2** para almacenamiento. La estructura incluye controladores, servicios y una implementación genérica para facilitar la reutilización de código.

## Características

- **Framework:** Spring Boot
- **Persistencia:** JPA (Java Persistence API)
- **Base de Datos:** H2 (en memoria)
- **Arquitectura de Capas:**
  - **Controladores**: Definen los endpoints para interactuar con las entidades.
  - **Servicios**: Contienen la lógica de negocio y gestionan las transacciones.
  - **Implementación Genérica**: Servicios y controladores genéricos reutilizables para las entidades.

## Requisitos

- **Java 17+**
- **Maven** (para gestionar las dependencias)
- **Spring Boot 2.7+**

## Tecnologías Utilizadas

- **Spring Boot**: Framework para facilitar el desarrollo de aplicaciones empresariales Java.
- **JPA**: Interfaz de persistencia para el acceso a la base de datos.
- **H2 Database**: Base de datos en memoria utilizada para fines de desarrollo y prueba.
- **Lombok**: Biblioteca para reducir la cantidad de código repetitivo (como getters, setters, etc.).

## Estructura del Proyecto

El proyecto sigue una arquitectura basada en capas:

