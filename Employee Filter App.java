import java.util.*;
import java.util.function.Predicate;

public class EmployeeFilterApp {
    static class Employee {
        String name, department;
        double salary;

        Employee(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String toString() {
            return name + " - " + department + " - " + salary;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR", 50000));
        employees.add(new Employee("Bob", "IT", 70000));
        employees.add(new Employee("Charlie", "Finance", 60000));
        employees.add(new Employee("Dave", "IT", 80000));

        System.out.println("1. Filter by salary\n2. Filter by department");
        int choice = sc.nextInt();
        sc.nextLine();
        Predicate<Employee> condition = null;

        if (choice == 1) {
            System.out.print("Enter minimum salary: ");
            double sal = sc.nextDouble();
            condition = e -> e.salary >= sal;
        } else if (choice == 2) {
            System.out.print("Enter department: ");
            String dept = sc.nextLine();
            condition = e -> e.department.equalsIgnoreCase(dept);
        }

        employees.stream().filter(condition).forEach(System.out::println);
    }
}
