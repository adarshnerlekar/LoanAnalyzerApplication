# LoanAnalyzerApplication
# 🚀 Digital Loan Eligibility & Risk Analyzer

A secure and scalable **backend system** that evaluates loan eligibility and analyzes risk levels using real-world financial rules.  
Built to simulate how modern banking and fintech platforms process loan applications.

---

## 🔍 Why This Project?
Financial institutions need **fast, accurate, and secure** loan decisions.  
This project automates loan eligibility checks and risk classification using backend business logic and secure REST APIs.

---

## ✨ Key Highlights
✔ Real-world **Banking & FinTech use case**  
✔ Secure APIs with **JWT authentication**  
✔ **Role-based access control** (Admin / User)  
✔ Clean **Controller–Service–Repository architecture**  
✔ Production-ready coding standards  

---

## 🚀 Features
- Loan eligibility calculation based on:
  - Applicant income  
  - Credit score  
  - Loan amount  
- Risk classification:
  - 🟢 Low Risk  
  - 🟡 Medium Risk  
  - 🔴 High Risk  
- Secure login & signup using JWT  
- Role-based authorization (ADMIN / USER)  
- RESTful APIs with proper HTTP status codes  
- Global exception handling & input validation  

---

## 🛠️ Tech Stack
| Category | Technologies |
|--------|--------------|
| Language | Java |
| Framework | Spring Boot |
| Security | Spring Security, JWT |
| Database | MySQL |
| ORM | Spring Data JPA, Hibernate |
| API Testing | Postman |

---

## 🏗️ System Architecture
This project follows a **layered architecture** for scalability and maintainability:

- **Controller Layer** – Handles REST API requests & responses  
- **Service Layer** – Contains business logic and risk evaluation rules  
- **Repository Layer** – Handles database interactions using JPA  

---

## 🔐 Security Implementation
- JWT-based authentication  
- Role-based authorization  
- Secured endpoints for admin and user operations  
- Password encryption using BCrypt  

---

## 📊 Risk Evaluation Logic
Loan risk is determined using predefined business rules:

- **Low Risk:** High credit score and affordable loan amount  
- **Medium Risk:** Moderate credit score or income  
- **High Risk:** Low credit score or high loan-to-income ratio  

---

## 📦 Modules
- User Authentication & Authorization  
- Loan Application Processing  
- Risk Analysis Engine  
- Admin & User Access Management  

---

## ▶️ How to Run the Project
1. Clone the repository  
   ```bash
   git clone https://github.com/your-username/digital-loan-eligibility-risk-analyzer.git
