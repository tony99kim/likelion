package day08.task4;

public class task4 {
    public static void main(String[] args) {

    }
}

abstract class Payment {
    double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    abstract void pay();
}

class CardPayment extends Payment {

    @Override
    void pay() {
        System.out.println("신용카드로 " + amount + " 원 결제하였습니다.");


    }
    public CardPayment(double amount) {
        super(amount);
    }
}

class PaypalPayment extends Payment {
    @Override
    void pay() {
        System.out.println("Paypal로 " + amount + " 원 결제하였습니다.");
    }
    public PaypalPayment(double amount) {
        super(amount);
    }
}