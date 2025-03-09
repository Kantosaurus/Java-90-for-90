import java.util.*;

public class calculator {
    private static double previousAnswer = 0; // Variable to store the previous answer

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Custom Calculator!");
        System.out.println("Enter a mathematical expression or an algebraic equation (e.g., '2x + 5 = 15', '3x^2 + 5x^2'): ");
        System.out.println("Use 'ans' to refer to the previous answer.");
        System.out.println("Type 'exit' to quit.");

        while (true) {
            System.out.print("What would you like to calculate? ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Calculator closed. Goodbye!");
                break;
            }

            try {
                // Replace 'ans' with the previous answer
                input = input.replace("ans", Double.toString(previousAnswer));

                if (input.contains("=")) {
                    // Solve the algebraic equation
                    double solution = solveAlgebraicEquation(input);
                    System.out.println("Solution: x = " + formatNumber(solution));
                    previousAnswer = solution; // Save the solution as the previous answer
                } else if (input.contains("x")) {
                    // Simplify the algebraic expression
                    String simplified = simplifyAlgebraicExpression(input);
                    System.out.println("Simplified Expression: " + simplified);
                } else {
                    // Evaluate the numerical expression
                    List<String> tokens = tokenize(input); // Step 1: Tokenize
                    List<String> postfix = shuntingYard(tokens); // Step 2: Convert to postfix
                    double result = evaluatePostfix(postfix); // Step 3: Evaluate postfix
                    System.out.println("Result: " + formatNumber(result));

                    // Save the result as the previous answer
                    previousAnswer = result;
                }
            } catch (Exception e) {
                System.out.println("Invalid expression! Please check your input and try again.");
            }
        }

        scanner.close();
    }

    // Simplify an algebraic expression like "3x^2 + 5x^2"
    private static String simplifyAlgebraicExpression(String expression) {
        Map<Integer, Double> coefficients = new HashMap<>(); // Key: power, Value: coefficient
        double constantTerm = 0; // Constant term

        // Split the expression into terms
        String[] terms = expression.split("(?=[+-])"); // Split by '+' or '-'
        for (String term : terms) {
            term = term.trim();
            if (term.contains("x")) {
                // Extract coefficient and power of x
                String coeffPart = term.split("x")[0].trim();
                double coeff = coeffPart.isEmpty() || coeffPart.equals("+") ? 1 :
                               coeffPart.equals("-") ? -1 : Double.parseDouble(coeffPart);

                int power = 1; // Default power is 1
                if (term.contains("^")) {
                    String powerPart = term.split("\\^")[1].trim();
                    power = Integer.parseInt(powerPart);
                }

                // Add to coefficients map
                coefficients.put(power, coefficients.getOrDefault(power, 0.0) + coeff);
            } else {
                // Constant term
                constantTerm += Double.parseDouble(term);
            }
        }

        // Build the simplified expression
        StringBuilder result = new StringBuilder();
        List<Integer> powers = new ArrayList<>(coefficients.keySet());
        Collections.sort(powers, Collections.reverseOrder()); // Sort powers in descending order

        for (int power : powers) {
            double coeff = coefficients.get(power);
            if (coeff == 0) continue;

            if (result.length() > 0 && coeff > 0) {
                result.append(" + ");
            }
            if (coeff == -1 && power != 0) {
                result.append("-");
            } else if (coeff != 1 || power == 0) {
                result.append(formatNumber(coeff));
            }

            if (power > 0) {
                result.append("x");
                if (power > 1) {
                    result.append("^").append(power);
                }
            }
        }

        if (constantTerm != 0) {
            if (result.length() > 0 && constantTerm > 0) {
                result.append(" + ");
            }
            result.append(formatNumber(constantTerm));
        }

        return result.length() > 0 ? result.toString() : "0"; // Return "0" if no terms
    }

    // Solve an algebraic equation of the form ax^n + bx + c = d
    private static double solveAlgebraicEquation(String equation) {
        // Split the equation into LHS and RHS
        String[] parts = equation.split("=");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid equation format. Use 'ax^n + bx + c = d'.");
        }

        String lhs = parts[0].trim(); // Left-hand side
        String rhs = parts[1].trim(); // Right-hand side

        // Parse coefficients from the LHS
        double a = 0, b = 0, c = 0;
        String[] terms = lhs.split("(?=[+-])"); // Split by '+' or '-'
        for (String term : terms) {
            term = term.trim();
            if (term.contains("x")) {
                // Extract coefficient and power of x
                String coeffPart = term.split("x")[0].trim();
                double coeff = coeffPart.isEmpty() || coeffPart.equals("+") ? 1 :
                               coeffPart.equals("-") ? -1 : Double.parseDouble(coeffPart);

                int power = 1; // Default power is 1
                if (term.contains("^")) {
                    String powerPart = term.split("\\^")[1].trim();
                    power = Integer.parseInt(powerPart);
                }

                if (power == 1) {
                    b += coeff; // Linear term
                } else if (power == 2) {
                    a += coeff; // Quadratic term
                } else {
                    throw new IllegalArgumentException("Only linear and quadratic equations are supported.");
                }
            } else {
                // Constant term
                c += Double.parseDouble(term);
            }
        }

        // Parse constant from the RHS
        double d = Double.parseDouble(rhs);

        // Solve for x: ax^2 + bx + c = d => ax^2 + bx + (c - d) = 0
        double adjustedC = c - d;

        if (a == 0) {
            // Linear equation: bx + adjustedC = 0
            if (b == 0) {
                throw new ArithmeticException("No solution or infinite solutions.");
            }
            return -adjustedC / b;
        }

        // Quadratic equation: ax^2 + bx + adjustedC = 0
        double discriminant = b * b - 4 * a * adjustedC;
        if (discriminant < 0) {
            throw new ArithmeticException("No real solutions (discriminant < 0).");
        }

        double sqrtDiscriminant = Math.sqrt(discriminant);
        double root1 = (-b + sqrtDiscriminant) / (2 * a);
        double root2 = (-b - sqrtDiscriminant) / (2 * a);

        if (root1 == root2) {
            return root1; // Single solution
        } else {
            throw new ArithmeticException("Multiple solutions: " + formatNumber(root1) + " and " + formatNumber(root2));
        }
    }

    // Format a number to remove unnecessary decimal points
    private static String formatNumber(double value) {
        if (value == (int) value) {
            return Integer.toString((int) value); // Convert to integer if no fractional part
        }
        return Double.toString(value); // Keep as double otherwise
    }

    // Tokenization function
    private static List<String> tokenize(String input) {
        List<String> tokens = new ArrayList<>();
        StringBuilder numberBuffer = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (Character.isDigit(c) || c == '.') { // Handle numbers
                numberBuffer.append(c);
            } else if (Character.isLetter(c)) { // Handle trigonometric functions or 'ans'
                StringBuilder funcBuffer = new StringBuilder();
                while (i < input.length() && Character.isLetter(input.charAt(i))) {
                    funcBuffer.append(input.charAt(i));
                    i++;
                }
                i--; // Adjust index after the loop
                String func = funcBuffer.toString().toLowerCase();
                if (func.equals("sin") || func.equals("cos") || func.equals("tan")) {
                    tokens.add(func); // Add trigonometric function
                } else if (!func.equals("ans")) { // 'ans' is already replaced
                    throw new IllegalArgumentException("Unknown function: " + func);
                }
            } else {
                if (numberBuffer.length() > 0) { // Add the number to tokens
                    tokens.add(numberBuffer.toString());
                    numberBuffer.setLength(0); // Clear buffer
                }

                if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')' || c == '^') {
                    tokens.add(Character.toString(c)); // Add operator or parenthesis
                } else if (!Character.isWhitespace(c)) {
                    throw new IllegalArgumentException("Unexpected character: " + c);
                }
            }
        }

        if (numberBuffer.length() > 0) { // Add any remaining number
            tokens.add(numberBuffer.toString());
        }

        return tokens;
    }

    // Shunting Yard Algorithm
    private static List<String> shuntingYard(List<String> tokens) {
        List<String> output = new ArrayList<>();
        Deque<String> operators = new ArrayDeque<>(); // Stack for operators

        Map<String, Integer> precedence = Map.of(
            "+", 1, "-", 1,
            "*", 2, "/", 2,
            "^", 3, // Power operator has highest precedence
            "sin", 4, "cos", 4, "tan", 4 // Trigonometric functions have highest precedence
        );

        Map<String, Boolean> associativity = Map.of(
            "+", true, "-", true,
            "*", true, "/", true,
            "^", false // Power operator is right-associative
        );

        for (String token : tokens) {
            if (isNumber(token)) { // If it's a number, add to output
                output.add(token);
            } else if (isOperator(token) || isFunction(token)) { // Operator or function
                while (!operators.isEmpty() && isOperator(operators.peek()) &&
                       ((associativity.get(token) && precedence.get(operators.peek()) >= precedence.get(token)) ||
                        (!associativity.get(token) && precedence.get(operators.peek()) > precedence.get(token)))) {
                    output.add(operators.pop()); // Pop higher precedence operators
                }
                operators.push(token); // Push current operator/function
            } else if (token.equals("(")) { // Left parenthesis
                operators.push(token);
            } else if (token.equals(")")) { // Right parenthesis
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    output.add(operators.pop()); // Pop until matching '('
                }
                if (!operators.isEmpty()) {
                    operators.pop(); // Remove '('
                } else {
                    throw new IllegalArgumentException("Mismatched parentheses");
                }
            }
        }

        while (!operators.isEmpty()) { // Pop remaining operators
            String op = operators.pop();
            if (op.equals("(") || op.equals(")")) {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            output.add(op);
        }

        return output;
    }

    // Postfix Evaluation
    private static double evaluatePostfix(List<String> postfix) {
        Deque<Double> stack = new ArrayDeque<>();

        for (String token : postfix) {
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token)); // Push number onto stack
            } else if (isOperator(token)) {
                double b = stack.pop(); // Second operand
                double a = stack.pop(); // First operand
                double result = applyOperator(a, b, token); // Apply operator
                stack.push(result); // Push result back onto stack
            } else if (isFunction(token)) {
                double arg = stack.pop(); // Argument for the function
                double result = applyFunction(arg, token); // Apply trigonometric function
                stack.push(result); // Push result back onto stack
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression");
        }

        return stack.pop(); // Final result
    }

    // Helper Methods
    private static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^");
    }

    private static boolean isFunction(String token) {
        return token.equals("sin") || token.equals("cos") || token.equals("tan");
    }

    private static double applyOperator(double a, double b, String operator) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) throw new ArithmeticException("Division by zero");
                return a / b;
            case "^": return Math.pow(a, b); // Exponentiation
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    private static double applyFunction(double arg, String function) {
        switch (function) {
            case "sin":
                return Math.sin(Math.toRadians(arg)); // Convert degrees to radians
            case "cos":
                return Math.cos(Math.toRadians(arg)); // Convert degrees to radians
            case "tan":
                return Math.tan(Math.toRadians(arg)); // Convert degrees to radians
            default:
                throw new IllegalArgumentException("Unknown function: " + function);
        }
    }
}