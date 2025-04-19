import java.util.Scanner;

abstract class Vehicle {
    protected String brand;
    protected String model;

    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public abstract void displayInfo();
}

class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, String model, int numberOfDoors) {
        super(brand, model);
        this.numberOfDoors = numberOfDoors;
    }

    public void displayInfo() {
        System.out.println("\nVehicle Type: Car");
        System.out.println("Brand        : " + brand);
        System.out.println("Model        : " + model);
        System.out.println("Doors        : " + numberOfDoors);
    }
}

class Bike extends Vehicle {
    private boolean hasCarrier;

    public Bike(String brand, String model, boolean hasCarrier) {
        super(brand, model);
        this.hasCarrier = hasCarrier;
    }

    public void displayInfo() {
        System.out.println("\nVehicle Type: Bike");
        System.out.println("Brand        : " + brand);
        System.out.println("Model        : " + model);
        System.out.println("Has Carrier  : " + (hasCarrier ? "Yes" : "No"));
    }
}

class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String brand, String model, double loadCapacity) {
        super(brand, model);
        this.loadCapacity = loadCapacity;
    }

    public void displayInfo() {
        System.out.println("\nVehicle Type: Truck");
        System.out.println("Brand        : " + brand);
        System.out.println("Model        : " + model);
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}

public class Vehicle_Management {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Car Brand: ");
        String carBrand = scanner.nextLine();
        System.out.print("Enter Car Model: ");
        String carModel = scanner.nextLine();
        System.out.print("Enter Number of Doors: ");
        int carDoors = scanner.nextInt();
        scanner.nextLine();

        System.out.print("\nEnter Bike Brand: ");
        String bikeBrand = scanner.nextLine();
        System.out.print("Enter Bike Model: ");
        String bikeModel = scanner.nextLine();
        System.out.print("Does the bike have a carrier? (true/false): ");
        boolean hasCarrier = scanner.nextBoolean();
        scanner.nextLine();

        System.out.print("\nEnter Truck Brand: ");
        String truckBrand = scanner.nextLine();
        System.out.print("Enter Truck Model: ");
        String truckModel = scanner.nextLine();
        System.out.print("Enter Load Capacity (tons): ");
        double loadCapacity = scanner.nextDouble();

        Vehicle v1 = new Car(carBrand, carModel, carDoors);
        Vehicle v2 = new Bike(bikeBrand, bikeModel, hasCarrier);
        Vehicle v3 = new Truck(truckBrand, truckModel, loadCapacity);

        v1.displayInfo();
        v2.displayInfo();
        v3.displayInfo();

        scanner.close();
    }
}
