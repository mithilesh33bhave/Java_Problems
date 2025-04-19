abstract class Vehicle {
    String make;
    String model;
    int year;
    String fuelType;

    Vehicle(String make, String model, int year, String fuelType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
    }

    abstract double calculateFuelEfficiency();
    abstract double getMaxSpeed();

    double calculateDistance(double fuelUsed) {
        return fuelUsed * calculateFuelEfficiency();
    }

    void displayInfo() {
        System.out.println("\n--- Vehicle Info ---");
        System.out.println("Type     : " + this.getClass().getSimpleName());
        System.out.println("Make     : " + make);
        System.out.println("Model    : " + model);
        System.out.println("Year     : " + year);
        System.out.println("Fuel Type: " + fuelType);
    }
}

class Car extends Vehicle {
    Car(String make, String model, int year, String fuelType) {
        super(make, model, year, fuelType);
    }

    double calculateFuelEfficiency() {
        return 16.0;
    }

    double getMaxSpeed() {
        return 180.0;
    }
}

class Truck extends Vehicle {
    Truck(String make, String model, int year, String fuelType) {
        super(make, model, year, fuelType);
    }

    double calculateFuelEfficiency() {
        return 6.5;
    }

    double getMaxSpeed() {
        return 120.0;
    }
}

class Motorcycle extends Vehicle {
    Motorcycle(String make, String model, int year, String fuelType) {
        super(make, model, year, fuelType);
    }

    double calculateFuelEfficiency() {
        return 40.0;
    }

    double getMaxSpeed() {
        return 150.0;
    }
}

public class Main8 {
    public static void main(String[] args) {
        Vehicle myCar = new Car("Honda", "City", 2022, "Petrol");
        Vehicle myTruck = new Truck("Tata", "LPT 1618", 2020, "Diesel");
        Vehicle myBike = new Motorcycle("Yamaha", "FZ", 2023, "Petrol");

        Vehicle[] vehicles = {myCar, myTruck, myBike};

        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.printf("Fuel Efficiency: %.2f km/l\n", v.calculateFuelEfficiency());
            System.out.printf("Max Speed      : %.2f km/h\n", v.getMaxSpeed());
            System.out.printf("Distance on 10L: %.2f km\n", v.calculateDistance(10));
            System.out.println();
        }
    }
}