# Project 33: URL Shortener

## Description
A simple URL shortening service that converts long URLs into shorter, more manageable versions. The application provides features for shortening URLs, retrieving original URLs, and managing URL mappings.

## Java Concepts Covered
- Object-Oriented Programming (OOP)
- Collections Framework (HashMap)
- String Manipulation
- Random Number Generation
- Input Validation
- Exception Handling

## Setup Instructions
1. Make sure you have Java Development Kit (JDK) installed on your system
2. Compile the Java files:
   ```
   javac URLShortener.java URLShortenerApp.java
   ```
3. Run the application:
   ```
   java URLShortenerApp
   ```

## Features
- Convert long URLs to short, random strings
- Retrieve original URLs from shortened versions
- List all URL mappings
- Basic URL validation
- Duplicate URL detection
- Customizable short URL length

## Example Usage
1. Run the program
2. Choose option 1 to shorten a URL
3. Enter a valid URL (must start with http:// or https://)
4. Use option 2 to retrieve the original URL
5. Use option 3 to view all URL mappings
6. Choose option 4 to exit the program

## Notes
- This is a simplified version of a URL shortener
- URL mappings are not persisted between program runs
- The system uses a 6-character random string for short URLs
- Future improvements could include:
  - Data persistence using files or database
  - Custom short URL generation
  - URL expiration
  - Click tracking
  - Web interface
  - API endpoints 