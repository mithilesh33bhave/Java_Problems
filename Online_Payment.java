import java.util.Scanner;

interface Payment {
    void pay(double amount);
}

class Card implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Card.");
    }
}

class UPI implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI.");
    }
}

class NetBanking implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using NetBanking.");
    }
}

public class Online_Payment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Payment Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Select Payment Method: 1. Card  2. UPI  3. NetBanking");
        int choice = scanner.nextInt();

        Payment payment = null;

        if (choice == 1) {
            payment = new Card();
        } else if (choice == 2) {
            payment = new UPI();
        } else if (choice == 3) {
            payment = new NetBanking();
        } else {
            System.out.println("Invalid choice");
        }

        if (payment != null) {
            payment.pay(amount);
        }

        scanner.close();
    }
}
