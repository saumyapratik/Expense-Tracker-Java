import java.io.*;
import java.util.*;

class ExpenseManager {
    private List<Expense> expenses = new ArrayList<>();
    private final String fileName = "expenses.txt";

    // Load expenses from file
    public void loadExpenses() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                expenses.add(Expense.fromFileString(line));
            }
        } catch (IOException e) {
            System.out.println("No previous data found.");
        }
    }

    // Save expense to file
    public void saveExpense(Expense expense) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write(expense.toFileString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving expense.");
        }
    }

    // Add expense
    public void addExpense(double amount, String category, String date) {
        Expense expense = new Expense(amount, category, date);
        expenses.add(expense);
        saveExpense(expense);
        System.out.println("Expense added successfully!");
    }

    // View all expenses
    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        for (Expense e : expenses) {
            System.out.println("Amount: " + e.amount +
                    ", Category: " + e.category +
                    ", Date: " + e.date);
        }
    }

    // Calculate total
    public void showTotal() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.amount;
        }
        System.out.println("Total Expense: " + total);
    }

    // Category-wise report
    public void categoryReport() {
        Map<String, Double> map = new HashMap<>();

        for (Expense e : expenses) {
            map.put(e.category,
                    map.getOrDefault(e.category, 0.0) + e.amount);
        }

        for (String category : map.keySet()) {
            System.out.println(category + ": " + map.get(category));
        }
    }
    // Show expenses with index
public void viewExpensesWithIndex() {
    if (expenses.isEmpty()) {
        System.out.println("No expenses found.");
        return;
    }

    for (int i = 0; i < expenses.size(); i++) {
        Expense e = expenses.get(i);
        System.out.println((i + 1) + ". Amount: " + e.amount +
                ", Category: " + e.category +
                ", Date: " + e.date);
    }
}

// Delete expense
public void deleteExpense(int index) {
    if (index < 1 || index > expenses.size()) {
        System.out.println("Invalid index!");
        return;
    }

    expenses.remove(index - 1);
    rewriteFile();
    System.out.println("Expense deleted successfully!");
}

// Rewrite file after deletion
private void rewriteFile() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
        for (Expense e : expenses) {
            bw.write(e.toFileString());
            bw.newLine();
        }
    } catch (IOException e) {
        System.out.println("Error updating file.");
    }
}
}