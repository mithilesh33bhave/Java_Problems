import java.io.*;
import java.util.*;

class Expense implements Serializable {
    String category;
    double amount;

    Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    public String toString() {
        return category + ": " + amount;
    }
}

public class BudgetTrackerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Expense> expenses = new HashMap<>();
        File file = new File("budget.dat");

        try {
            if (file.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                expenses = (HashMap<String, Expense>) ois.readObject();
                ois.close();
            }
        } catch (Exception ignored) {}

        while (true) {
            System.out.println("1. Add Expense\n2. View Expenses\n3. Save & Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Category: ");
                String cat = sc.nextLine();
                System.out.print("Amount: ");
                double amt = sc.nextDouble();
                sc.nextLine();
                expenses.put(cat, new Expense(cat, amt));
            } else if (choice == 2) {
                expenses.values().forEach(System.out::println);
            } else {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                    oos.writeObject(expenses);
                } catch (IOException e) {
                    System.out.println("Save error.");
                }
                break;
            }
        }
    }
}
