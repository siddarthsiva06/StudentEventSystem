# 🎓 Student Event Management System

A full-stack web application that allows students to register, log in securely using JWT authentication, and manage their personal event registrations.

Built using a microservices architecture with Spring Boot on the backend and React + TypeScript on the frontend.

---

## 🚀 Features

### Student Service
- Student Registration
- Secure Login
- BCrypt Password Encryption
- JWT Token Generation
- Duplicate Email Validation
- Duplicate Roll Number Validation

### Event Service
- Add New Event
- View Events by Student
- JWT Protected APIs
- MongoDB Storage

### Frontend
- Register Page
- Login Page
- Event Dashboard
- Add Event Form
- Responsive UI using Tailwind CSS

---

## 🛠 Tech Stack

### Frontend
- React
- TypeScript
- Vite
- Tailwind CSS

### Backend
- Spring Boot
- Spring Security
- JWT Authentication
- BCrypt Password Encoder
- Maven

### Database
- MongoDB

### Tools
- Postman
- Git
- GitHub
- VS Code
- IntelliJ IDEA

---

## 📂 Project Structure

```
StudentEventSystem
│
├── student-backend
│   ├── student-service
│   └── event-service
│
├── student-frontend
│
├── screenshots
│
└── README.md
```

---

## ⚙️ How to Run

### 1. Clone Repository

```bash
git clone https://github.com/YOUR_USERNAME/StudentEventSystem.git
```

---

### 2. Start MongoDB

Make sure MongoDB is running locally.

---

### 3. Run Student Service

```bash
cd student-backend/student-service
mvn spring-boot:run
```

Runs on

```
http://localhost:8081
```

---

### 4. Run Event Service

```bash
cd student-backend/event-service
mvn spring-boot:run
```

Runs on

```
http://localhost:8082
```

---

### 5. Run Frontend

```bash
cd student-frontend

npm install

npm run dev
```

Runs on

```
http://localhost:5173
```

---

## 🔐 Authentication

The application uses JWT Authentication.

Workflow:

```
Register
      ↓
Login
      ↓
JWT Token Generated
      ↓
Stored in Local Storage
      ↓
Used for Protected Event APIs
```

Passwords are securely encrypted using BCrypt before being stored in MongoDB.

---

## 📸 Screenshots

### Register

![Register](screenshots/register.png)

---

### Login

![Login](screenshots/login.png)

---

### Student Dashboard

![Dashboard](screenshots/dashboard.png)

---

### Add Event

![Add Event](screenshots/add-event.png)

---

### Event List

![Events](screenshots/events.png)

---

### JWT Authentication (Postman)

![JWT](screenshots/jwt-postman.png)

---

### Student Database

![Student DB](screenshots/student-db.png)

---

### Event Database

![Event DB](screenshots/event-db.png)

---

## 📡 REST API Endpoints

### Student Service

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/students/register` | Register Student |
| POST | `/api/students/login` | Login Student |
| GET | `/api/students/roll/{rollNumber}` | Get Student |

---

### Event Service

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/events/add` | Add Event |
| GET | `/api/events/student/{rollNumber}` | Get Student Events |

---

## Future Improvements

- Edit Events
- Delete Events
- Event Search
- Pagination
- Admin Dashboard
- Email Notifications
- Docker Support
- Deployment to AWS/Render

---

## 👨‍💻 Author

**Siddarth Subramaniam Siva**

B.E Computer Science Engineering  
SSN College of Engineering

---

## 📄 License

This project is developed for learning purposes.