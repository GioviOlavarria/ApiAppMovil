# Backend

Este repositorio contiene el **backend de la aplicación móvil XtremeShop**, desarrollado con **Spring Boot**.  
Provee una **API REST** para la gestión de usuarios y productos de una tienda en línea, utilizando **PostgreSQL** como base de datos y pensado para despliegue en plataformas como **Railway**.

## Características

- API REST para:
  - Gestión de **usuarios** (`/api/users`)
  - Gestión de **productos** (`/api/products`)
  - Endpoint de prueba (`/api/hola`)
- Integración con **PostgreSQL** mediante **Spring Data JPA**
- Soporte para roles de usuario (por ejemplo: `USER`, `ADMIN`)
- Configuración lista para entorno local y despliegue en la nube

## Tecnologías

- Java  
- Spring Boot (Spring Web, Spring Data JPA)  
- PostgreSQL  
- Gradle  
