abstract class Employee {
    String name;
    String address;
    double salary;
    String jobTitle;

    Employee(String name, String address, double salary, String jobTitle) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }

    abstract double calculateBonus();
    abstract void generatePerformanceReport();
    abstract void manageProject();

    void displayInfo() {
        System.out.println("\n--- Employee Info ---");
        System.out.println("Name     : " + name);
        System.out.println("Address  : " + address);
        System.out.println("Salary   : $" + salary);
        System.out.println("Job Title: " + jobTitle);
    }
}

class Manager extends Employee {
    Manager(String name, String address, double salary) {
        super(name, address, salary, "Manager");
    }

    double calculateBonus() {
        return salary * 0.20;
    }

    void generatePerformanceReport() {
        System.out.println("Manager " + name + " generated a department-wide performance report.");
    }

    void manageProject() {
        System.out.println("Manager " + name + " is overseeing multiple projects.");
    }
}

class Developer extends Employee {
    Developer(String name, String address, double salary) {
        super(name, address, salary, "Developer");
    }

    double calculateBonus() {
        return salary * 0.15;
    }

    void generatePerformanceReport() {
        System.out.println("Developer " + name + " submitted a sprint report.");
    }

    void manageProject() {
        System.out.println("Developer " + name + " is working on a software development project.");
    }
}

class Programmer extends Employee {
    Programmer(String name, String address, double salary) {
        super(name, address, salary, "Programmer");
    }

    double calculateBonus() {
        return salary * 0.10;
    }

    void generatePerformanceReport() {
        System.out.println("Programmer " + name + " generated a code quality report.");
    }

    void manageProject() {
        System.out.println("Programmer " + name + " is contributing to backend systems.");
    }
}

public class Main9 {
    public static void main(String[] args) {
        Employee manager = new Manager("Alice", "New York", 90000);
        Employee developer = new Developer("Bob", "San Francisco", 75000);
        Employee programmer = new Programmer("Charlie", "Chicago", 65000);

        Employee[] employees = {manager, developer, programmer};

        for (Employee emp : employees) {
            emp.displayInfo();
            System.out.println("Bonus: $" + emp.calculateBonus());
            emp.generatePerformanceReport();
            emp.manageProject();
            System.out.println();
        }
    }
}
