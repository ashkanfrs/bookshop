# Bookshop

An online bookstore application built with Spring Boot. This project features user authentication, book browsing, and purchase functionalities, allowing users to search for and buy their favorite books. Users can add books to their shopping cart. The application is designed with a robust back-end.

## Features

- User authentication (registration, login)
- Search functionality
- Add books to the shopping cart
- Purchase books

## Technologies Used

- Spring Boot
- Spring Data JPA
- PostgresSQL

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- PostgresSQL

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/ashkanfrs/bookshop.git
    ```
2. Navigate to the project directory:
    ```bash
    cd bookshop
    ```
3. Set up the PostgresSQL database:
    ```sql
    CREATE DATABASE bookshop;
    ```
4. Update the `application.properties` file with your PostgreSQL database credentials:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/bookshop
    spring.datasource.username=your-username
    spring.datasource.password=your-password

    spring.jpa.hibernate.ddl-auto=update
    ```
5. Build the project:
    ```bash
    mvn clean install
    ```
6. Run the application:
    ```bash
    mvn spring-boot:run
    ```

### Usage

1. The back-end server will start on `http://localhost:8081`.
2. Use tools like Postman or curl to interact with the API endpoints for user registration, login, book browsing, and purchasing.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any changes.
