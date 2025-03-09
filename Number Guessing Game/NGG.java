import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class NGG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! What is your name? ");
        String name = scanner.nextLine().trim();
        System.out.println("Hello " + name + "!");

        boolean playAgain = true; // Control variable for the "play again" loop

        while (playAgain) {
            int difficulty;
            while (true) {
                difficulty = getDifficulty(scanner);
                if (difficulty >= 1 && difficulty <= 4) {
                    break; // Valid input, exit the loop
                }
                System.out.println("Invalid difficulty! Please choose a number from 1 to 4.");
            }

            switch (difficulty) {
                case 1:
                    System.out.println(name + " has chosen difficulty 1!");
                    System.out.println("You have 3 tries to guess a number between 1 and 10 inclusive.");
                    System.out.println("Goodluck " + name + "!");
                    difficulty1(scanner, name);
                    break;

                case 2:
                    System.out.println(name + " has chosen difficulty 2!");
                    System.out.println("You have 7 tries to guess a number between 1 and 100 inclusive.");
                    System.out.println("Goodluck " + name + "!");
                    difficulty2(scanner, name);
                    break;

                case 3:
                    System.out.println(name + " has chosen difficulty 3!");
                    System.out.println("You have 10 tries to guess a number between 1 and 1000 inclusive.");
                    System.out.println("Goodluck " + name + "!");
                    difficulty3(scanner, name);
                    break;

                case 4:
                    System.out.println("Goodbye " + name + "!");
                    playAgain = false; // Exit the "play again" loop
                    break;
            }

            // Ask the user if they want to play again
            if (playAgain) {
                System.out.println("Would you like to play again? (yes/no): ");
                String response = scanner.next().trim().toLowerCase();
                if (!response.equals("yes")) {
                    System.out.println("Thank you for playing! Goodbye!");
                    playAgain = false; // Exit the "play again" loop
                }
                scanner.nextLine(); // Consume the remaining newline character
            }
        }

        scanner.close(); // Close the scanner at the end
    }

    // Method to get the difficulty level from the user
    public static int getDifficulty(Scanner scanner) {
        System.out.println("Please choose the difficulty of the game (1-4): ");
        while (!scanner.hasNextInt()) { // Validate input to ensure it's an integer
            System.out.println("Invalid input! Please enter a number between 1 and 4.");
            scanner.next(); // Clear invalid input
        }
        return scanner.nextInt();
    }

    // Helper function to generate a random number
    private static int randomNumberGenerator(int x) {
        return ThreadLocalRandom.current().nextInt(1, x + 1);
    }

    // Helper function for guessing
    public static void guess(Scanner scanner, String name, int limit, int number) {
        int numberOfTries = 1;
        while (numberOfTries <= limit) {
            System.out.println(name + ", what is guess number " + numberOfTries + "?");
            int guess = scanner.nextInt();
            if (guess > number) {
                System.out.println("The number you guessed was too big!");
            } else if (guess < number) {
                System.out.println("The number you guessed is too small!");
            } else {
                System.out.println("You Win! " + name + " only took " + numberOfTries + " number of tries!");
                return;
            }
            numberOfTries++;
        }
        System.out.println("Oops, the number was: " + number);
        System.out.println("Better luck next time!");
    }

    // Difficulty 1 game
    public static void difficulty1(Scanner scanner, String name) {
        int number = randomNumberGenerator(10);
        int limit = 3;
        guess(scanner, name, limit, number);
    }

    // Difficulty 2 game
    public static void difficulty2(Scanner scanner, String name) {
        int number = randomNumberGenerator(100);
        int limit = 7;
        guess(scanner, name, limit, number);
    }

    // Difficulty 3 game
    public static void difficulty3(Scanner scanner, String name) {
        int number = randomNumberGenerator(1000);
        int limit = 10;
        guess(scanner, name, limit, number);
    }
}