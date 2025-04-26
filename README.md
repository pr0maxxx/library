# Library Application

Приложение для управления библиотекой. Оно включает в себя функциональность для добавления книг, пользователей и записи пользователей на книги.

## Требования

- JDK 1.8
- SpringBoot 2.x
- Maven
- Spring Web
- PostgreSQL 14 (для хранения данных)

---

## 📦 Как запустить

1. **Скачайте и распакуйте архив проекта**

   Убедитесь, что у вас установлен [Docker Desktop](https://www.docker.com/products/docker-desktop/) и он запущен.

2. **Откройте командную строку** в корне проекта (где находится `docker-compose.yml`)

3. **Выполните команду:**

   ```bash
   docker-compose up --build
   ```
   Это соберёт и запустит контейнер.

4. **Перейдите в браузере по адресу:**

   ```bash
   http://localhost:8080/swagger-ui/index.html
    ```
   Здесь находится Swagger-документация с интерфейсом для тестирования.


---
## GET Эндпоинты
1. **Получение клиентов**

   GET http://localhost:8080/clients - Получает список всех клиентов.

2. **Получение книг**

   GET http://localhost:8080/books - Получает список всех книг.

3. **Получение записей**

   GET http://localhost:8080/readings - Получает список всех записей.

## POST Эндпоинты
1. **Создание клиента**
   POST http://localhost:8080/clients - Создаёт нового клиента.

   Request Body:
   ```bash
   {
   "name": "Иван",
   "birthDate": "1990-07-15"
   }
   ```
   Response:
   ```bash
   {
   "id": 1,
   "name": "Иван",
   "birthDate": "1990-07-15"
   }
   ```
2. **Создание книги**
   POST http://localhost:8080/books - Создаёт новую книгу.

   Request Body:
   ```bash
   {
   "title": "Война и мир",
   "author": "Лев Толстой",
   "isbn": "1234567821"
   }
   ```
   Response:
   ```bash
   {
   "id": 1,
   "title": "Война и мир",
   "author": "Лев Толстой",
   "isbn": "1234567821"
   }
   ```
3. **Создание записи**
   POST http://localhost:8080/readings - Создаёт новую запись.

   Request Body:
   ```bash
   {
   "clientId": 1,
   "bookId": 1
   }
   ```
   Response:
   ```bash
   {
    "id": 1,
    "client": {
        "id": 1,
        "fullName": "Иван Иванов",
        "birthDate": "1990-05-15"
    },
    "book": {
        "id": 1,
        "title": "Война и мир",
        "author": "Лев Толстой",
        "isbn": "1234567890"
    },
    "readingDate": "2025-04-26T19:09:42.736"
   }
   ```

## PUT Эндпоинты
1. **Изменение клиента**
   PUT http://localhost:8080/clients/{id} - Изменяет клиента с указанным id.

   Request Body:
   ```bash
   {
   "name": "Иван",
   "birthDate": "1990-07-16"
   }
   ```
   Response:
   ```bash
   {
   "id": 1,
   "name": "Иван",
   "birthDate": "1990-07-16"
   }
   ```
2. **Изменение книги**
   PUT http://localhost:8080/books/{id} - Изменяет книгу с указанным id.

   Request Body:
   ```bash
   {
   "title": "Война и мир",
   "author": "Лев Толстой",
   "isbn": "1234567891"
   }
   ```
   Response:
   ```bash
   {
   "id": 1,
   "title": "Война и мир",
   "author": "Лев Толстой",
   "isbn": "1234567891"
   }
   ```
