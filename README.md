# 📰 Newspaper practice System

Welcome to the **Newspaper Management System**, a fully functional Spring Boot application designed to manage users, news articles, and categories. This project demonstrates the power of Spring Boot combined with RESTful APIs for creating a clean and intuitive content management system. 🚀

## 🔥 Features

- **User Management**: Create, update, delete, and retrieve user information, along with login functionality.
- **News Articles**: Manage news articles with features like create, read, update, delete, and search by category, title, or user.
- **Categories**: Manage news categories with create, read, update, and delete functionality.
- **Pagination**: Easily paginate through news articles with configurable page sizes.
- **Top Users**: Retrieve top users with the most published news articles.
- **Cross-Origin Support**: Enabled CORS for easier front-end integration.

---
## 🎨 Frontend

- **Aesthetic Elements**
- We aimed for a clean and intuitive design, keeping the API responses simple yet effective. The UI, developed in React, brings this vision to life by providing a visually stunning interface for end-users. Check out the UI repository
- <a>https://github.com/Sri-lanka/newspaper-practice-react</a>
---

## 🛠️ Technologies Used

- **Spring Boot** - The framework powering the backend of this application.
- **Spring Data JPA** - For seamless interaction with the H2 in-memory database.
- **RESTful API** - Exposes the CRUD operations via REST endpoints.
- **Mysql** - A database simple.


---

## 🚀 Getting Started

### Prerequisites

Before running the project, make sure you have the following installed:

- **Java 17+**

### Installation

1. **Clone the repository**:
    ```bash
    git clone https://github.com/OscarNavarrolol/newspaper-practice.git
    cd newspaper-practice
    ```

2. **Run the application**:
    ```bash
    mvn spring-boot:run or start the server from the main class
    ```

4. **Access the API**:
    - The application will run at `http://localhost:8083`.
    - Check the available API endpoints below.

---

## 🌐 API Endpoints

### User Management

| Method | Endpoint                     | Description                    |
|--------|-------------------------------|--------------------------------|
| GET    | `/api_user/list`              | Get all users                  |
| GET    | `/api_user/get_user/{id}`      | Get user by ID                 |
| POST   | `/api_user/create_user`        | Create a new user              |
| PUT    | `/api_user/update_user/{id}`   | Update user details            |
| DELETE | `/api_user/delete_user/{id}`   | Delete a user                  |
| POST   | `/api_user/register`           | Register a new user            |
| GET    | `/api_user/check`              | Check login credentials        |
| GET    | `/api_user/top_users`          | Get top users by news count    |

### News Management

| Method | Endpoint                          | Description                        |
|--------|------------------------------------|------------------------------------|
| GET    | `/api_new/list_news`               | Get all news articles              |
| GET    | `/api_new/get_new/{id}`            | Get news by ID                     |
| POST   | `/api_new/create_new`              | Create a new article               |
| PUT    | `/api_new/update_new/{id}`         | Update news article                |
| DELETE | `/api_new/delete_new/{id}`         | Delete news article                |
| GET    | `/api_new/recent_new`              | Get most recent news               |
| GET    | `/api_new/category_new/{id_category}` | Get news by category (with pagination) |
| GET    | `/api_new/list_news/{user_id}`     | Get news by user (with pagination) |
| GET    | `/api_new/search`                  | Search news by title               |

### Category Management

| Method | Endpoint                          | Description                        |
|--------|------------------------------------|------------------------------------|
| GET    | `/api_category/list_category`      | Get all categories                 |
| GET    | `/api_category/get_category/{id}`  | Get category by ID                 |
| POST   | `/api_category/create_category`    | Create a new category              |
| PUT    | `/api_category/update_category/{id}` | Update category                    |
| DELETE | `/api_category/delete_category/{id}` | Delete category                    |

---

## 🧩 Future Improvements

- **User Authentication**: Implement OAuth2 or JWT for secure authentication.
- **Commenting System**: Allow users to comment on news articles.
- **Role-Based Access**: Differentiate between admin and regular users.

---

## 📜 License

This project is licensed under the MIT License.

---

## 👨‍💻 Contribuitors
Backend Developer: [OscarNavarrolol](https://github.com/OscarNavarrolol)
Frontend Developer: [Sri-lanka](https://github.com/Sri-lanka)
