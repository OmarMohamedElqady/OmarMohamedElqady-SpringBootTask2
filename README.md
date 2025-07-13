# 📚 Quantum Bookstore – Spring Boot Project

Welcome to **Quantum Bookstore**, a simple and extensible online book store backend system built with **Java** and **Spring Boot**.  
This project was created as a solution for the **Fawry N² Dev Slope Challenge #10**.

---

## 🚀 Features

- Manage inventory of 3 types of books:
  - 📦 **Paper Book** – can be shipped and has limited stock.
  - 📥 **EBook** – has a file type and is sent via email.
  - 🖼️ **Showcase/Demo Book** – not for sale.

- ✅ Add a book with:
  - ISBN
  - Title
  - Year of publication
  - Price
  - Author
  - (Optional: filetype or stock based on book type)

- ❌ Remove outdated books (older than specified number of years)

- 🛒 Buy a book by ISBN:
  - Checks availability
  - Reduces stock if paper book
  - Returns total price paid
  - "Ships" via ShippingService or MailService *(mocked / not implemented)*

- 📦 All print statements are prefixed with: `Quantum book store`

---

## 🧠 System Design Notes

- 📐 **Extensible Design**: Uses inheritance to allow adding new book types without modifying existing logic.
- 🧱 Book Types inherit from a base `Book` class and override behavior as needed.
- 🧪 A separate class `QuantumBookstoreFullTest` is provided for testing major features (add, remove, buy).

---

## 📂 Project pictures




![image](https://github.com/user-attachments/assets/fa9392c5-4899-49ed-a9a9-13d14d21275f)


![image](https://github.com/user-attachments/assets/1fc52c58-ace4-4591-b7e0-dcc7bd1f6bb0)


![image](https://github.com/user-attachments/assets/16b78db2-4d11-4abb-948e-f925abf60a4a)


![image](https://github.com/user-attachments/assets/548818c2-5972-4366-b9e9-849a4ad65028)


![image](https://github.com/user-attachments/assets/cd5ece17-ee48-475c-8250-c17173773499)



