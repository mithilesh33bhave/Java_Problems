import java.util.*;

public class BankingAppWithSynchronizedAccount {
    static class Account {
        private int balance;

        Account(int balance) {
            this.balance = balance;
        }

        synchronized void withdraw(int amount) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " withdrew " + amount);
            } else {
                System.out.println(Thread.currentThread().getName() + " insufficient funds");
            }
        }

        synchronized void deposit(int amount) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited " + amount);
        }

        synchronized int getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter initial balance: ");
        int initialBalance = sc.nextInt();
        Account account = new Account(initialBalance);

        Thread t1 = new Thread(() -> account.withdraw(700), "User1");
        Thread t2 = new Thread(() -> account.withdraw(500), "User2");
        Thread t3 = new Thread(() -> account.deposit(300), "User3");

        t1.start();
        t2.start();
        t3.start();
    }
}