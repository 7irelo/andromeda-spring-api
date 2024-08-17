# Andromeda Spring Framework API

Welcome to the Andromeda Spring Framework Neo4j API project! This project is a backend API for a social media platform called Andromeda, developed using the Spring Framework, Neo4j, and Redis. The API provides CRUD functionality for various entities such as users, posts, comments, likes, friendships, products, and notifications. It uses Spring Data Neo4j for database operations and JWT for authentication.

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
- Relationships managed in Neo4j, leveraging its graph database capabilities
- Redis integration for caching and session management
- Notifications for likes and comments
- RESTful API design
- Swagger documentation for API endpoints

## Technologies

- Java 22
- Spring Framework
- Spring Security
- Spring Data Neo4j
- Neo4j
- Redis
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
│   │   │   │       │   ├── Neo4jConfig.java
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
│   │       └── schema.cypher
└── pom.xml
```

## Installation

### Prerequisites

- Java 22
- Neo4j
- Redis
- Maven

### Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/7irelo/andromeda-spring-api.git
   cd andromeda-spring-api
   ```

2. Set up Neo4j and Redis:

   - **Neo4j**: Install and start Neo4j, then create a database named `andromeda_neo4j`.
   - **Redis**: Install and start Redis.

3. Update `application.properties`:

   ```properties
   spring.neo4j.uri=bolt://localhost:7687
   spring.neo4j.authentication.username=neo4j
   spring.neo4j.authentication.password=your_password

   spring.redis.host=localhost
   spring.redis.port=6379

   jwt.secret=your_jwt_secret
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
