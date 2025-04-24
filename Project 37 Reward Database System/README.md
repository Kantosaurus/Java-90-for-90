# Project 37: Reward Database System

## Description
A comprehensive reward system that manages user points, membership tiers, and rewards. The system allows for adding and removing users, tracking points, managing membership tiers, and generating reports. It implements a tiered membership system with Bronze, Silver, Gold, and Platinum levels.

## Java Concepts Covered
- Object-Oriented Programming (OOP)
- Collections Framework
- Stream API
- Exception Handling
- Input Validation
- String Manipulation
- Control Flow

## Setup Instructions
1. Make sure you have Java Development Kit (JDK) installed on your system
2. Compile the Java files:
   ```
   javac User.java RewardSystem.java RewardSystemApp.java
   ```
3. Run the application:
   ```
   java RewardSystemApp
   ```

## Features
- User management (add, remove, view)
- Points system (add, redeem)
- Tiered membership system
- Automatic tier updates based on points
- Points tracking and reporting
- User ranking and statistics
- Multiple view options (all users, by tier, top users)

## Example Usage
1. Run the program
2. Choose option 1 to add a new user
3. Enter user details (ID, name)
4. Use options 3-4 to manage points
5. Use option 5 to view users in different ways
6. Choose option 6 to exit the program

## Notes
- This is a simplified version of a reward system
- User data is not persisted between program runs
- Future improvements could include:
  - Data persistence using files or database
  - User authentication and authorization
  - Transaction history
  - Reward catalog
  - Point expiration
  - Special promotions and bonuses
  - Email notifications
  - Web interface
  - API integration 