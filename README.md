# Andromeda Spring Framework JDBC API

Welcome to the Andromeda Spring Framework JDBC API project! This project is a backend API for a social media platform called Andromeda, developed using the Spring Framework and PostgreSQL. The API provides CRUD functionality for various entities such as users, posts, comments, likes, friendships, products, and notifications. It uses Spring JDBC for database operations and JWT for authentication.

## Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Project Structure](#project-structure)
- [Installation](#installation)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
- [License](#license)

## Features

- User authentication and authorization using JWT
- CRUD operations for users, posts, comments, likes, friendships, products, and notifications
- Many-to-many relationships with intermediate tables
- Notifications for likes and comments
- RESTful API design
- Swagger documentation for API endpoints

## Technologies

- Java 22
- Spring Framework
- Spring Security
- Spring JDBC
- PostgreSQL
- Swagger

## Project Structure

```
andromeda/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   └── andromeda/
│   │   │   │       ├── config/
│   │   │   │       │   ├── SecurityConfig.java
│   │   │   │       │   └── SwaggerConfig.java
│   │   │   │       ├── controller/
│   │   │   │       │   ├── AuthController.java
│   │   │   │       │   ├── CommentController.java
│   │   │   │       │   ├── FriendshipController.java
│   │   │   │       │   ├── LikeController.java
│   │   │   │       │   ├── NotificationController.java
│   │   │   │       │   ├── PostController.java
│   │   │   │       │   ├── ProductController.java
│   │   │   │       │   └── UserController.java
│   │   │   │       ├── dto/
│   │   │   │       │   ├── CommentDTO.java
│   │   │   │       │   ├── FriendshipDTO.java
│   │   │   │       │   ├── LikeDTO.java
│   │   │   │       │   ├── NotificationDTO.java
│   │   │   │       │   ├── PostDTO.java
│   │   │   │       │   ├── ProductDTO.java
│   │   │   │       │   └── UserDTO.java
│   │   │   │       ├── entity/
│   │   │   │       │   ├── Comment.java
│   │   │   │       │   ├── Friendship.java
│   │   │   │       │   ├── Like.java
│   │   │   │       │   ├── Notification.java
│   │   │   │       │   ├── Post.java
│   │   │   │       │   ├── Product.java
│   │   │   │       │   └── User.java
│   │   │   │       ├── repository/
│   │   │   │       │   ├── CommentRepository.java
│   │   │   │       │   ├── FriendshipRepository.java
│   │   │   │       │   ├── LikeRepository.java
│   │   │   │       │   ├── NotificationRepository.java
│   │   │   │       │   ├── PostRepository.java
│   │   │   │       │   ├── ProductRepository.java
│   │   │   │       │   └── UserRepository.java
│   │   │   │       ├── service/
│   │   │   │       │   ├── AuthService.java
│   │   │   │       │   ├── CommentService.java
│   │   │   │       │   ├── FriendshipService.java
│   │   │   │       │   ├── LikeService.java
│   │   │   │       │   ├── NotificationService.java
│   │   │   │       │   ├── PostService.java
│   │   │   │       │   ├── ProductService.java
│   │   │   │       │   └── UserService.java
│   │   │   │       └── util/
│   │   │   │           ├── JwtTokenUtil.java
│   │   │   │           └── PasswordUtil.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── schema.sql
└── pom.xml
```

## Installation

### Prerequisites

- Java 22
- PostgreSQL
- Maven

### Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/7irelo/andromeda-spring-api.git
   cd andromeda-spring-api
   ```

2. Set up PostgreSQL:

   ```bash
   psql -U postgres -c "CREATE DATABASE andromeda_spring;"
   psql -U postgres -c "CREATE USER andromeda_user WITH PASSWORD 'password';"
   psql -U postgres -c "GRANT ALL PRIVILEGES ON DATABASE andromeda_asp TO andromeda_user;"
   ```

3. Update `application.properties`:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/andromeda_spring
   spring.datasource.username=postgres
   spring.datasource.password=password
   ```

4. Run the project:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## Usage

### Authentication

Use the `/auth/login` and `/auth/register` endpoints to obtain a JWT token. This token must be included in the `Authorization` header for all other API requests.

### API Endpoints

Refer to the [Swagger documentation](http://localhost:8080/swagger-ui.html) for a detailed list of all available endpoints and their usage.

## API Documentation

Swagger is integrated for API documentation. You can access it at [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a new branch (`git checkout -b feature/your-feature-name`)
3. Commit your changes (`git commit -am 'Add some feature'`)
4. Push to the branch (`git push origin feature/your-feature-name`)
5. Create a new Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

Feel free to customize the README as per your project's specific details and requirements.
