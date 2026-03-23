import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        manager.loadExpenses(); // load existing data

        while (true) {
            System.out.println("\n==== Expense Tracker ====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Show Total");
            System.out.println("4. Category-wise Report");
            System.out.println("5. Delete Expense");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = sc.nextLine();

                    manager.addExpense(amount, category, date);
                    break;

                case 2:
                    manager.viewExpenses();
                    break;

                case 3:
                    manager.showTotal();
                    break;

                case 4:
                    manager.categoryReport();
                    break;

                case 5:
    manager.viewExpensesWithIndex();
    System.out.print("Enter expense number to delete: ");
    int index = sc.nextInt();
    manager.deleteExpense(index);
    break;

     case 6:
    System.out.println("Exiting...");
    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}