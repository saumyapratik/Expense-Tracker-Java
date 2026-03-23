class Expense {
    double amount;
    String category;
    String date;

    // Constructor
    Expense(double amount, String category, String date) {
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    // Convert object to string (for saving in file)
    public String toFileString() {
        return amount + "," + category + "," + date;
    }

    // Convert string from file to object
    public static Expense fromFileString(String line) {
        String[] parts = line.split(",");
        return new Expense(
            Double.parseDouble(parts[0]),
            parts[1],
            parts[2]
        );
    }
}
