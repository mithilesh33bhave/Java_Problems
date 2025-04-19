import java.util.*;
import java.util.concurrent.*;

public class RestaurantOrderProcessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BlockingQueue<String> orderQueue = new ArrayBlockingQueue<>(5);
        String[] orders = new String[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter order " + (i + 1) + ": ");
            orders[i] = sc.nextLine();
        }

        Thread waiter = new Thread(() -> {
            for (String order : orders) {
                try {
                    orderQueue.put(order);
                    System.out.println("Waiter placed: " + order);
                } catch (InterruptedException ignored) {}
            }
        });

        Thread chef = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    String order = orderQueue.take();
                    System.out.println("Chef preparing: " + order);
                    Thread.sleep(400);
                } catch (InterruptedException ignored) {}
            }
        });

        waiter.start();
        chef.start();
    }
}