import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
    }

    public Book findBook(String isbn) {
        return books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    public List<Book> searchByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Book> searchByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Book> getAvailableBooks() {
        return books.stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }

    public List<Book> getBorrowedBooks() {
        return books.stream()
                .filter(book -> !book.isAvailable())
                .collect(Collectors.toList());
    }

    public void borrowBook(String isbn, String borrower, String dueDate) {
        Book book = findBook(isbn);
        if (book != null && book.isAvailable()) {
            book.borrow(borrower, dueDate);
        }
    }

    public void returnBook(String isbn) {
        Book book = findBook(isbn);
        if (book != null && !book.isAvailable()) {
            book.returnBook();
        }
    }

    public void displayAllBooks() {
        System.out.println("\n=== Library Catalog ===");
        books.forEach(System.out::println);
    }

    public void displayAvailableBooks() {
        System.out.println("\n=== Available Books ===");
        getAvailableBooks().forEach(System.out::println);
    }

    public void displayBorrowedBooks() {
        System.out.println("\n=== Borrowed Books ===");
        getBorrowedBooks().forEach(System.out::println);
    }

    public int getTotalBooks() {
        return books.size();
    }

    public int getAvailableBooksCount() {
        return (int) books.stream().filter(Book::isAvailable).count();
    }
} 