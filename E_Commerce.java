import java.util.Scanner;

class Product {
    String productId;
    String name;
    String category;
    double price;
    int quantity;
    double discount;

    public Product(String productId, String name, String category, double price, int quantity, double discount) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }


    public String setProductId(String productId) {
        this.productId = productId;
        return productId;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public String setCategory(String category) {
        this.category = category;
        return category;
    }

    public double setPrice(double price) {
        if (price >= 0)
            this.price = price;
            return price;
    }


    public int setQuantity(int quantity) {
        if (quantity >= 0)
            this.quantity = quantity;
            return quantity;
    }

    public double setDiscount(double discount) {
        if (discount >= 0 && discount <= 100)
            this.discount = discount;
            return discount;
    }

    public double getDiscountedPrice() {
        return price - (price * discount / 100);
    }

    public void displayProduct() {
        System.out.println("\n--- Product Details ---");
        System.out.println("Product ID  : " + productId);
        System.out.println("Name        : " + name);
        System.out.println("Category    : " + category);
        System.out.println("Price       : $" + price);
        System.out.println("Discount    : " + discount + "%");
        System.out.println("Final Price : $" + getDiscountedPrice());
        System.out.println("Quantity    : " + quantity);
        System.out.println("------------------------");
    }
}

public class E_Commerce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Product ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Category: ");
        String category = scanner.nextLine();

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter Discount (%): ");
        double discount = scanner.nextDouble();

        Product userProduct = new Product(id, name, category, price, quantity, discount);

        userProduct.displayProduct();

        scanner.close();
    }
}
