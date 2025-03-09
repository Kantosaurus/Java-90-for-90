# Project Name: Advanced Calculator

## Description
This project implements a feature-rich console-based calculator in Java. It supports:
- Basic arithmetic operations (addition, subtraction, multiplication, division).
- Simplification of algebraic expressions (e.g., `3x^2 + 5x^2` → `8x^2`).
- Solving linear and quadratic equations (e.g., `2x + 5 = 15`, `x^2 - 4x + 4 = 0`).
- Handling powers (`^`) with proper precedence and right-associativity.
- Trigonometric functions (`sin`, `cos`, `tan`) with input in degrees.
- Use of the previous answer (`ans`) in subsequent calculations.

The calculator is designed to handle complex mathematical expressions while maintaining user-friendly interaction.

---

## Java Concepts Covered
- **Basic Arithmetic Operations**: Addition, subtraction, multiplication, and division.
- **Algebraic Expression Parsing**: Simplifying and solving algebraic expressions.
- **Shunting Yard Algorithm**: Converting infix expressions to postfix notation for evaluation.
- **Postfix Evaluation**: Evaluating mathematical expressions using a stack.
- **Exception Handling**: Managing invalid inputs, division by zero, and mismatched parentheses.
- **Trigonometric Functions**: Supporting `sin`, `cos`, and `tan` with degree-to-radian conversion.
- **Power Operator**: Handling exponentiation (`^`) with proper precedence and associativity.
- **User Input Handling**: Using `Scanner` to read and process user input dynamically.

---

## Features
1. **Basic Arithmetic**:
   - Perform operations like `3 + 5`, `10 / 2`, or `2 * (3 + 5)`.

2. **Algebraic Expressions**:
   - Simplify expressions involving variables (e.g., `3x + 5x` → `8x`, `3x^2 + 5x^2` → `8x^2`).

3. **Equation Solving**:
   - Solve linear equations (e.g., `2x + 5 = 15` → `x = 5`).
   - Solve quadratic equations (e.g., `x^2 - 4x + 4 = 0` → `x = 2`).

4. **Powers**:
   - Handle exponentiation with proper precedence and right-associativity (e.g., `2^3^2` → `512`).

5. **Trigonometric Functions**:
   - Evaluate trigonometric expressions (e.g., `sin(30)`, `cos(60)`).

6. **Previous Answer (`ans`)**:
   - Use the result of the previous calculation in new expressions (e.g., `ans + 5`).

7. **Error Handling**:
   - Gracefully handle invalid inputs, division by zero, and mismatched parentheses.

---

## Setup Instructions
1. **Prerequisites**:
   - Ensure you have Java installed on your system. You can verify this by running:
     ```bash
     java -version
     ```
     If not installed, download and install the latest version of Java from [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) or [OpenJDK](https://openjdk.org/).

2. **Save the Code**:
   - Save the provided `.java` file (e.g., `AdvancedCalculator.java`) in a directory.

3. **Compile the Program**:
   - Open a terminal or command prompt, navigate to the directory containing the `.java` file, and compile the program:
     ```bash
     javac AdvancedCalculator.java
     ```

4. **Run the Program**:
   - Execute the compiled program using:
     ```bash
     java AdvancedCalculator
     ```

5. **Interact with the Calculator**:
   - Follow the on-screen instructions to enter mathematical expressions or equations.
   - Type `exit` to quit the program.

---

## Known Limitations
1. **Quadratic Equations**:
   - Only real solutions are supported. Complex solutions will throw an error.
2. **Higher Powers**:
   - The simplification logic currently supports up to quadratic terms (`x^2`). Higher powers (e.g., `x^3`) are not fully implemented.
3. **Trigonometric Functions**:
   - Inputs are interpreted in degrees. Radian support is not included.
4. **Multiple Solutions**:
   - For quadratic equations with two distinct real roots, the program throws an exception instead of displaying both solutions.

---

## Future Enhancements
1. **Support for Higher Powers**:
   - Extend the simplification logic to handle terms like `x^3`, `x^4`, etc.
2. **Complex Numbers**:
   - Add support for complex solutions in quadratic equations.
3. **Radians Mode**:
   - Allow users to switch between degrees and radians for trigonometric functions.
4. **Graphical User Interface (GUI)**:
   - Develop a GUI for better user interaction.
5. **Advanced Functions**:
   - Add support for logarithms, factorials, and other mathematical functions.

---

## Contribution Guidelines
Contributions are welcome! If you'd like to improve this project:
1. Fork the repository.
2. Create a new branch for your changes.
3. Submit a pull request with a detailed description of your enhancements.

---

## License
This project is open-source and available under the [MIT License](https://opensource.org/licenses/MIT). Feel free to use, modify, and distribute it as needed.