import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ExpenseTrackerApp {
    private static Scanner scanner = new Scanner(System.in);
    private static ExpenseTracker tracker = new ExpenseTracker();
    private static final String[] CATEGORIES = {
        "Food", "Transportation", "Housing", "Entertainment", 
        "Utilities", "Shopping", "Healthcare", "Other"
    };

    public static void main(String[] args) {
        boolean running = true;
        
        while (running) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    viewAllExpenses();
                    break;
                case 3:
                    viewExpensesByCategory();
                    break;
                case 4:
                    viewExpensesByDateRange();
                    break;
                case 5:
                    tracker.generateReport();
                    break;
                case 6:
                    running = false;
                    System.out.println("Thank you for using the Expense Tracker!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n=== Expense Tracker ===");
        System.out.println("1. Add New Expense");
        System.out.println("2. View All Expenses");
        System.out.println("3. View Expenses by Category");
        System.out.println("4. View Expenses by Date Range");
        System.out.println("5. Generate Report");
        System.out.println("6. Exit");
    }

    private static void addExpense() {
        System.out.print("Enter expense description: ");
        String description = scanner.nextLine();
        
        double amount = getDoubleInput("Enter amount: $");
        
        System.out.println("\nSelect category:");
        for (int i = 0; i < CATEGORIES.length; i++) {
            System.out.printf("%d. %s%n", i + 1, CATEGORIES[i]);
        }
        
        int categoryChoice = getIntInput("Enter category number: ") - 1;
        if (categoryChoice < 0 || categoryChoice >= CATEGORIES.length) {
            System.out.println("Invalid category choice.");
            return;
        }
        
        Expense expense = new Expense(description, amount, CATEGORIES[categoryChoice]);
        tracker.addExpense(expense);
        System.out.println("Expense added successfully!");
    }

    private static void viewAllExpenses() {
        System.out.println("\n=== All Expenses ===");
        tracker.getAllExpenses().forEach(System.out::println);
    }

    private static void viewExpensesByCategory() {
        System.out.println("\n=== Expenses by Category ===");
        tracker.getExpensesByCategory().forEach((category, amount) -> 
            System.out.printf("%s: $%.2f%n", category, amount));
    }

    private static void viewExpensesByDateRange() {
        System.out.println("\nEnter date range (YYYY-MM-DD):");
        LocalDate startDate = getDateInput("Start date: ");
        LocalDate endDate = getDateInput("End date: ");
        
        System.out.println("\n=== Expenses in Date Range ===");
        tracker.getExpensesByDateRange(startDate, endDate).forEach(System.out::println);
    }

    private static LocalDate getDateInput(String prompt) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            }
        }
    }

    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            System.out.print(prompt);
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return input;
    }

    private static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a number.");
            System.out.print(prompt);
            scanner.next();
        }
        double input = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        return input;
    }
} 