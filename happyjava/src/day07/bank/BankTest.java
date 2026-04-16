package day06.bank;

public class BankTest {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123-456", "김태엽");

        account.displayInfo();
        System.out.println("=====================");

        account.deposit(10000);
        account.withdraw(3000);
        account.withdraw(10000);

        System.out.println("---");
        System.out.println("현재 잔액: " + account.getBalance() + "원");
    }
}
