import java.util.*;

public class DecoratorPatternForFoodOrder {
    interface Food {
        String getDescription();
        double getCost();
    }

    static class Pizza implements Food {
        public String getDescription() {
            return "Pizza";
        }

        public double getCost() {
            return 100.0;
        }
    }

    static abstract class ToppingDecorator implements Food {
        protected Food food;
        ToppingDecorator(Food food) {
            this.food = food;
        }
    }

    static class Cheese extends ToppingDecorator {
        Cheese(Food food) {
            super(food);
        }

        public String getDescription() {
            return food.getDescription() + ", Cheese";
        }

        public double getCost() {
            return food.getCost() + 20;
        }
    }

    static class Olives extends ToppingDecorator {
        Olives(Food food) {
            super(food);
        }

        public String getDescription() {
            return food.getDescription() + ", Olives";
        }

        public double getCost() {
            return food.getCost() + 15;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Food order = new Pizza();
        System.out.print("Add cheese? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")) order = new Cheese(order);
        System.out.print("Add olives? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")) order = new Olives(order);
        System.out.println(order.getDescription());
        System.out.println("Total: " + order.getCost());
    }
}