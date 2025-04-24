import java.time.LocalDate;

public class Expense {
    private String description;
    private double amount;
    private LocalDate date;
    private String category;

    public Expense(String description, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.date = LocalDate.now();
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: $%.2f (%s)", 
            date.toString(), description, amount, category);
    }
} 