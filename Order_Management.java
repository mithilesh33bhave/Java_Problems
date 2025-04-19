import java.util.Scanner;

class Item {
    private String name;
    private int quantity;
    private double price;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public double getTotal() {
        return quantity * price;
    }

    public void display() {
        System.out.println(name + " - Qty: " + quantity + ", Unit Price: ₹" + price + ", Total: ₹" + getTotal());
    }
}

public class Order_Management {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter Customer Name: ");
            String customerName = scanner.nextLine();

            System.out.print("Enter Order ID: ");
            String orderId = scanner.nextLine();

            System.out.print("Enter Number of Items: ");
            int itemCount = Integer.parseInt(scanner.nextLine());

            Item[] items = new Item[itemCount];
            double grandTotal = 0;

            for (int i = 0; i < itemCount; i++) {
                System.out.println("\nItem " + (i + 1));
                System.out.print("Enter Item Name: ");
                String itemName = scanner.nextLine();

                System.out.print("Enter Quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine());

                System.out.print("Enter Price per Unit: ");
                double price = Double.parseDouble(scanner.nextLine());

                items[i] = new Item(itemName, quantity, price);
                grandTotal += items[i].getTotal();
            }

            System.out.println("\nOrder Summary");
            System.out.println("Customer Name: " + customerName);
            System.out.println("Order ID     : " + orderId);
            System.out.println("\nItems:");
            for (Item item : items) {
                item.display();
            }
            System.out.println("\nGrand Total: ₹" + grandTotal);

        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric input.");
        } catch (NullPointerException e) {
            System.out.println("Missing required data.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
