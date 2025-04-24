import java.util.Scanner;

public class URLShortenerApp {
    private static Scanner scanner = new Scanner(System.in);
    private static URLShortener shortener = new URLShortener();
    private static final String BASE_URL = "http://short.url/";

    public static void main(String[] args) {
        boolean running = true;
        
        while (running) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    shortenURL();
                    break;
                case 2:
                    getLongURL();
                    break;
                case 3:
                    listAllURLs();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using the URL Shortener!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n=== URL Shortener ===");
        System.out.println("1. Shorten a URL");
        System.out.println("2. Get Original URL");
        System.out.println("3. List All URLs");
        System.out.println("4. Exit");
    }

    private static void shortenURL() {
        System.out.print("Enter the long URL to shorten: ");
        String longURL = scanner.nextLine();
        
        if (!isValidURL(longURL)) {
            System.out.println("Invalid URL format. Please enter a valid URL.");
            return;
        }
        
        String shortURL = shortener.shortenURL(longURL);
        System.out.println("Shortened URL: " + BASE_URL + shortURL);
    }

    private static void getLongURL() {
        System.out.print("Enter the short URL (without " + BASE_URL + "): ");
        String shortURL = scanner.nextLine();
        
        String longURL = shortener.getLongURL(shortURL);
        System.out.println("Original URL: " + longURL);
    }

    private static void listAllURLs() {
        shortener.listAllURLs();
        System.out.println("Total URLs shortened: " + shortener.getTotalURLs());
    }

    private static boolean isValidURL(String url) {
        return url.startsWith("http://") || url.startsWith("https://");
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