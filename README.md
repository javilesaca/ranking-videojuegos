# 🎮 Ranking de Videojuegos - Spring Boot REST API

Aplicación web desarrollada con Spring Boot para gestionar un ranking de videojuegos. Permite realizar operaciones CRUD (crear, leer, actualizar, eliminar) sobre videojuegos, ordenarlos por ranking y más.

## 🚀 Características

- CRUD completo de videojuegos.
- Ordenamiento por ranking (descendente).
- Validaciones básicas en los datos.
- API REST con endpoints documentados.
- Persistencia de datos con JPA y H2 (modo desarrollo).
- Preparado para escalar con Docker y otras bases de datos.

---

## 🧱 Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- Swagger OpenAPI (documentación REST)
- Lombok (para evitar código boilerplate)

---

## 📦 Instalación

1. Clona el repositorio:

```bash
git clone https://github.com/javilesaca/ranking-videojuegos.git
cd ranking-videojuegos
```
2. Construye el proyecto:
   
```bash
./mvnw clean install
```
3. Ejecuta la aplicación:

```bash
./mvnw spring-boot:run
```
4. Accede a la API en: http://localhost:8080/api/videojuegos

---

 ## 📘 Endpoints principales

| Método |	Endpoint | Descripción |
|:-------|:----------|:------------|
| GET |	/api/videojuegos |	Listar todos los videojuegos |
| GET |	/api/videojuegos/{id}	| Obtener un videojuego por ID |
| POST |	/api/videojuegos	| Crear un nuevo videojuego |
| PUT |	/api/videojuegos/{id}	| Actualizar un videojuego |
|DELETE |	/api/videojuegos/{id} |	Eliminar un videojuego |
| GET |	/api/videojuegos/ranking/top |	Ver top videojuegos por ranking |

---

## 🧪 Pruebas
En desarrollo. Se puede añadir pruebas con JUnit 5 y Spring Boot Test para validar los endpoints.

---

## ✍️ Autor
Javier Lesaca Medina

---

## ⭐ Licencia
Este proyecto está bajo la licencia MIT.


