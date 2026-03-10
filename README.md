# Student Attendance Management System (Java MVC)

A simple **Command Line Interface (CLI)** based **Student Attendance Management System** built using **Java** and structured with a **layered MVC architecture**.

This project demonstrates good software design practices including **separation of concerns**, **data persistence**, **input validation**, and **modular project structure**. It is designed as a **learning project for Java application architecture**.

---

# Features

* Add new students
* Delete students
* Mark attendance (Present / Absent)
* View attendance summary
* Attendance percentage calculation
* Attendance history tracking
* Data persistence using file storage
* CSV export for Excel
* Safe user input validation
* Duplicate student ID protection
* Clean MVC + Service + Repository architecture

---

# Project Architecture

This project follows a **layered MVC architecture** commonly used in real software systems.

```
User
 ↓
View (User Interface)
 ↓
Controller (Application Flow)
 ↓
Service (Business Logic)
 ↓
Repository (Data Management)
 ↓
Model (Data Structure)
```

Each layer has a **single responsibility**, making the system easier to maintain and extend.

---

# Project Structure

```
src
│
├─ app
│   └─ Main.java
│
├─ controller
│   └─ AttendanceController.java
│
├─ service
│   └─ AttendanceService.java
│
├─ repository
│   └─ StudentRepository.java
│
├─ model
│   ├─ Student.java
│   └─ Course.java
│
├─ view
│   └─ StudentView.java
│
└─ util
    ├─ FileStorage.java
    └─ CSVExporter.java
```

---

# Module Responsibilities

## Model

Represents the **core data structures** of the system.

**Student.java**

Stores:

* student id
* student name
* attendance record (`Map<LocalDate, Boolean>`)

Provides:

* present days count
* absent days count
* attendance percentage
* attendance history

---

## Repository

Handles **data storage and retrieval**.

**StudentRepository.java**

Responsibilities:

* store students in memory
* find student by ID
* return list of students
* load data from file on startup

---

## Service

Contains **business logic**.

**AttendanceService.java**

Responsibilities:

* add student
* delete student
* mark attendance
* prevent duplicate student IDs
* communicate between controller and repository

---

## Controller

Manages **application flow**.

**AttendanceController.java**

Responsibilities:

* process user actions
* call service layer
* display results via view
* save data when program exits

---

## View

Handles **user interaction**.

**StudentView.java**

Responsibilities:

* display menus
* receive user input
* show student information
* validate Y/N attendance input

---

## Utility

Provides **supporting functionality**.

### FileStorage.java

Handles:

* saving students to file
* loading students from file

Data file created:

```
students.txt
```

Example:

```
101,Ali
102,Siti
103,John
```

---

### CSVExporter.java

Exports attendance data to Excel-compatible format.

Output file:

```
attendance.csv
```

Example:

| ID  | Name | Present | Absent | Percentage |
| --- | ---- | ------- | ------ | ---------- |
| 101 | Ali  | 8       | 2      | 80         |

---

# How Attendance Is Stored

Each student keeps attendance in a **date-based map**.

```
Map<LocalDate, Boolean> attendance
```

Example:

```
2026-03-01 → Present
2026-03-02 → Absent
2026-03-03 → Present
```

This allows:

* attendance history
* daily tracking
* percentage calculation

---

# Input Validation

The system prevents invalid input.

### Attendance Input

Users enter:

```
Y / y → Present
N / n → Absent
```

Example:

```
Present today? (Y/N): y
```

---

### Numeric Input Protection

Student ID input is validated to prevent crashes if non-numeric input is entered.

Example:

```
Enter student ID: abc
Invalid number. Try again.
```

---

# How to Run the Program

### 1. Compile the project

```
javac app/Main.java
```

### 2. Run the application

```
java app.Main
```

---

# Example Program Output

```
===== Student Attendance System =====

1. Add Student
2. Delete Student
3. Mark Attendance
4. View Students
0. Exit

Choice: 1

Enter student ID: 101
Enter student name: Ali
Student added.
```

View students:

```
ID: 101 | Name: Ali | Present: 3 | Absent: 1 | Attendance: 75%
```

---

# Example Workflow

1. Add students
2. Mark daily attendance
3. View attendance statistics
4. Export CSV report
5. Exit system (data saved automatically)

---

# Future Improvements

Possible extensions for the system:

* Multiple course management
* Student search
* Attendance reports by date
* Login system for teachers
* Graphical UI using JavaFX
* Database storage (MySQL/PostgreSQL)
* REST API integration

---

# Learning Objectives

This project demonstrates:

* MVC architecture
* Layered application design
* Java collections
* File I/O
* input validation
* clean project structure
* separation of responsibilities

---

# Author

Asyraaf Zu

---

# License

This project is for **educational and learning purposes**.
