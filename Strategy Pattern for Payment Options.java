interface PaymentStrategy {
    void pay(double amount);
}

class UpiPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via UPI");
    }
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Credit Card");
    }
}

class PaymentContext {
    private PaymentStrategy strategy;

    void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    void executePayment(double amount) {
        strategy.pay(amount);
    }
}

public class StrategyPatternForPaymentOptions {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        context.setStrategy(new UpiPayment());
        context.executePayment(500.0);

        context.setStrategy(new CreditCardPayment());
        context.executePayment(800.0);
    }
}
