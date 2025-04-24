import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static Library library = new Library();

    public static void main(String[] args) {
        boolean running = true;
        
        while (running) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    displayBooks();
                    break;
                case 7:
                    running = false;
                    System.out.println("Thank you for using the Library Management System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n=== Library Management System ===");
        System.out.println("1. Add New Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Search Books");
        System.out.println("4. Borrow Book");
        System.out.println("5. Return Book");
        System.out.println("6. Display Books");
        System.out.println("7. Exit");
    }

    private static void addBook() {
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        
        Book book = new Book(isbn, title, author);
        library.addBook(book);
        System.out.println("Book added successfully!");
    }

    private static void removeBook() {
        System.out.print("Enter ISBN of book to remove: ");
        String isbn = scanner.nextLine();
        
        library.removeBook(isbn);
        System.out.println("Book removed successfully!");
    }

    private static void searchBook() {
        System.out.println("\nSearch by:");
        System.out.println("1. ISBN");
        System.out.println("2. Title");
        System.out.println("3. Author");
        
        int choice = getIntInput("Enter your choice: ");
        
        switch (choice) {
            case 1:
                System.out.print("Enter ISBN: ");
                String isbn = scanner.nextLine();
                Book book = library.findBook(isbn);
                if (book != null) {
                    System.out.println(book);
                } else {
                    System.out.println("Book not found.");
                }
                break;
                
            case 2:
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                List<Book> titleResults = library.searchByTitle(title);
                displaySearchResults(titleResults);
                break;
                
            case 3:
                System.out.print("Enter author: ");
                String author = scanner.nextLine();
                List<Book> authorResults = library.searchByAuthor(author);
                displaySearchResults(authorResults);
                break;
                
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void borrowBook() {
        System.out.print("Enter ISBN of book to borrow: ");
        String isbn = scanner.nextLine();
        
        System.out.print("Enter borrower name: ");
        String borrower = scanner.nextLine();
        
        System.out.print("Enter due date (YYYY-MM-DD): ");
        String dueDate = scanner.nextLine();
        
        library.borrowBook(isbn, borrower, dueDate);
        System.out.println("Book borrowed successfully!");
    }

    private static void returnBook() {
        System.out.print("Enter ISBN of book to return: ");
        String isbn = scanner.nextLine();
        
        library.returnBook(isbn);
        System.out.println("Book returned successfully!");
    }

    private static void displayBooks() {
        System.out.println("\nDisplay options:");
        System.out.println("1. All Books");
        System.out.println("2. Available Books");
        System.out.println("3. Borrowed Books");
        
        int choice = getIntInput("Enter your choice: ");
        
        switch (choice) {
            case 1:
                library.displayAllBooks();
                break;
            case 2:
                library.displayAvailableBooks();
                break;
            case 3:
                library.displayBorrowedBooks();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void displaySearchResults(List<Book> results) {
        if (results.isEmpty()) {
            System.out.println("No books found.");
        } else {
            System.out.println("\nSearch Results:");
            results.forEach(System.out::println);
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