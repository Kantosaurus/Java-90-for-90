import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExpenseTracker {
    private List<Expense> expenses;

    public ExpenseTracker() {
        this.expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public List<Expense> getAllExpenses() {
        return new ArrayList<>(expenses);
    }

    public double getTotalExpenses() {
        return expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public Map<String, Double> getExpensesByCategory() {
        return expenses.stream()
                .collect(Collectors.groupingBy(
                    Expense::getCategory,
                    Collectors.summingDouble(Expense::getAmount)
                ));
    }

    public List<Expense> getExpensesByDateRange(java.time.LocalDate startDate, java.time.LocalDate endDate) {
        return expenses.stream()
                .filter(expense -> !expense.getDate().isBefore(startDate) && 
                                 !expense.getDate().isAfter(endDate))
                .collect(Collectors.toList());
    }

    public void generateReport() {
        System.out.println("\n=== Expense Report ===");
        System.out.println("Total Expenses: $" + getTotalExpenses());
        
        System.out.println("\nExpenses by Category:");
        getExpensesByCategory().forEach((category, amount) -> 
            System.out.printf("%s: $%.2f%n", category, amount));
        
        System.out.println("\nRecent Expenses:");
        expenses.stream()
                .sorted((e1, e2) -> e2.getDate().compareTo(e1.getDate()))
                .limit(5)
                .forEach(System.out::println);
    }
} 