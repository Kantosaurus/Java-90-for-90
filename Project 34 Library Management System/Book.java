public class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean isAvailable;
    private String borrower;
    private String dueDate;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.borrower = null;
        this.dueDate = null;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getBorrower() {
        return borrower;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void borrow(String borrower, String dueDate) {
        if (isAvailable) {
            this.isAvailable = false;
            this.borrower = borrower;
            this.dueDate = dueDate;
        }
    }

    public void returnBook() {
        this.isAvailable = true;
        this.borrower = null;
        this.dueDate = null;
    }

    @Override
    public String toString() {
        return String.format("ISBN: %s, Title: %s, Author: %s, Available: %s%s",
            isbn, title, author, isAvailable ? "Yes" : "No",
            !isAvailable ? String.format(" (Borrowed by: %s, Due: %s)", borrower, dueDate) : "");
    }
} 