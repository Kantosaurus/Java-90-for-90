# Project 34: Library Management System

## Description
A comprehensive library management system that allows users to manage books, track borrowing, and handle library operations. The system provides features for adding and removing books, searching the catalog, managing book borrowing and returns, and generating reports.

## Java Concepts Covered
- Object-Oriented Programming (OOP)
- Collections Framework
- Stream API
- Exception Handling
- Input Validation
- String Manipulation
- Date Handling

## Setup Instructions
1. Make sure you have Java Development Kit (JDK) installed on your system
2. Compile the Java files:
   ```
   javac Book.java Library.java LibraryManagementSystem.java
   ```
3. Run the application:
   ```
   java LibraryManagementSystem
   ```

## Features
- Add and remove books from the library
- Search books by ISBN, title, or author
- Borrow and return books
- Track book availability
- Manage due dates
- View library catalog
- Generate reports on available and borrowed books

## Example Usage
1. Run the program
2. Choose option 1 to add a new book
3. Enter book details (ISBN, title, author)
4. Use options 3-6 to manage and view books
5. Use options 4-5 to handle book borrowing and returns
6. Choose option 7 to exit the program

## Notes
- This is a simplified version of a library management system
- Book data is not persisted between program runs
- Future improvements could include:
  - Data persistence using files or database
  - User authentication and authorization
  - Fine calculation for late returns
  - Book reservations
  - Multiple copy support
  - Book categories and genres
  - Member management
  - Email notifications for due dates 