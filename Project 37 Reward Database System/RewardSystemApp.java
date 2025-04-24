import java.util.Scanner;

public class RewardSystemApp {
    private static Scanner scanner = new Scanner(System.in);
    private static RewardSystem rewardSystem = new RewardSystem();

    public static void main(String[] args) {
        boolean running = true;
        
        while (running) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    removeUser();
                    break;
                case 3:
                    addPoints();
                    break;
                case 4:
                    redeemPoints();
                    break;
                case 5:
                    viewUsers();
                    break;
                case 6:
                    running = false;
                    System.out.println("Thank you for using the Reward System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n=== Reward System ===");
        System.out.println("1. Add New User");
        System.out.println("2. Remove User");
        System.out.println("3. Add Points");
        System.out.println("4. Redeem Points");
        System.out.println("5. View Users");
        System.out.println("6. Exit");
    }

    private static void addUser() {
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        
        User user = new User(userId, name);
        rewardSystem.addUser(user);
        System.out.println("User added successfully!");
    }

    private static void removeUser() {
        System.out.print("Enter User ID to remove: ");
        String userId = scanner.nextLine();
        
        rewardSystem.removeUser(userId);
        System.out.println("User removed successfully!");
    }

    private static void addPoints() {
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        
        int points = getIntInput("Enter points to add: ");
        
        if (rewardSystem.addPoints(userId, points)) {
            System.out.println("Points added successfully!");
        } else {
            System.out.println("User not found.");
        }
    }

    private static void redeemPoints() {
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        
        int points = getIntInput("Enter points to redeem: ");
        
        if (rewardSystem.redeemPoints(userId, points)) {
            System.out.println("Points redeemed successfully!");
        } else {
            System.out.println("User not found or insufficient points.");
        }
    }

    private static void viewUsers() {
        System.out.println("\nView options:");
        System.out.println("1. All Users");
        System.out.println("2. Users by Tier");
        System.out.println("3. Top Users");
        
        int choice = getIntInput("Enter your choice: ");
        
        switch (choice) {
            case 1:
                rewardSystem.displayAllUsers();
                break;
            case 2:
                System.out.println("\nSelect tier:");
                System.out.println("1. Bronze");
                System.out.println("2. Silver");
                System.out.println("3. Gold");
                System.out.println("4. Platinum");
                
                int tierChoice = getIntInput("Enter your choice: ");
                String tier;
                switch (tierChoice) {
                    case 1: tier = "Bronze"; break;
                    case 2: tier = "Silver"; break;
                    case 3: tier = "Gold"; break;
                    case 4: tier = "Platinum"; break;
                    default:
                        System.out.println("Invalid choice.");
                        return;
                }
                rewardSystem.displayUsersByTier(tier);
                break;
            case 3:
                int count = getIntInput("Enter number of top users to display: ");
                rewardSystem.displayTopUsers(count);
                break;
            default:
                System.out.println("Invalid choice.");
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
} 