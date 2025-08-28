

# Student Grade Management System (CLI Project)

## 📌 Project Description

This project is a simple **Student Grade Management System** built in Java.
It allows users to add student records, calculate grades based on marks, and view student details through a **menu-driven Command-Line Interface (CLI)**.

The project also supports **persistent storage** by saving student data in a file (`students.dat`), so data is not lost when the program is closed.

---

## 🎯 Features

* Add new student with roll number, name, and marks
* Automatic grade calculation (A, B, C, D) based on marks
* Login using roll number to view student details
* Persistent data storage using file handling (serialization)
* Simple and user-friendly menu system

---

## 🛠️ Technologies Used

* **Language:** Java
* **Concepts Used:** Classes, Objects, Serialization, File Handling, HashMap, CLI-based menu

---

## 📂 Project Structure

```
StudentGradeSystemCLI.java   # Main file containing all classes
students.dat                 # File to store student records (auto-generated)
README.md                    # Documentation
```

---

## 🚀 How to Run

1. Compile the program:

   ```
   javac StudentGradeSystemCLI.java
   ```
2. Run the program:

   ```
   java StudentGradeSystemCLI
   ```
3. Use the menu options to:

   * Add Student
   * Login with Roll Number
   * View Student Info

---

## 🎥 Demo Video

👉 [Watch the Demo](https://drive.google.com/file/d/xxxxxx/view?usp=sharing)



---

## 📊 Grade Criteria

* **A** → Marks ≥ 90
* **B** → Marks ≥ 75 and < 90
* **C** → Marks ≥ 50 and < 75
* **D** → Marks < 50

---

## ✅ Outcome

A working CLI system where students’ information is stored securely, and grades are automatically calculated and displayed.

---
