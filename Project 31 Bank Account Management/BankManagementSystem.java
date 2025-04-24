import java.util.Scanner;

public class BankManagementSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static BankAccount currentAccount = null;

    public static void main(String[] args) {
        boolean running = true;
        
        while (running) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    running = false;
                    System.out.println("Thank you for using the Bank Management System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n=== Bank Management System ===");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Check Balance");
        System.out.println("5. Exit");
    }

    private static void createAccount() {
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        currentAccount = new BankAccount(name);
        System.out.println("Account created successfully!");
        System.out.println("Account Number: " + currentAccount.getAccountNumber());
    }

    private static void deposit() {
        if (checkAccount()) {
            double amount = getDoubleInput("Enter amount to deposit: $");
            currentAccount.deposit(amount);
        }
    }

    private static void withdraw() {
        if (checkAccount()) {
            double amount = getDoubleInput("Enter amount to withdraw: $");
            currentAccount.withdraw(amount);
        }
    }

    private static void checkBalance() {
        if (checkAccount()) {
            currentAccount.checkBalance();
        }
    }

    private static boolean checkAccount() {
        if (currentAccount == null) {
            System.out.println("No account exists. Please create an account first.");
            return false;
        }
        return true;
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