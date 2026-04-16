package day07.bank;

public class BankAccount {
    private String accountNumber;
    private String owner;
    private int balance;

    public BankAccount(String accountNumber, String owner) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = 0;
    }

    public void deposit(int amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println(amount + "원이 입금되었습니다.");
        } else {
            System.out.println("입금액은 0보다 커야 합니다.");
        }
    }

    public boolean withdraw(int amount) {
        if(amount > balance) {
            System.out.println("잔액이 부족합니다.");
            return false;
        }
        balance -= amount;
        System.out.println(amount + "원이 출금되었습니다.");
        return true;
    }

    public int getBalance() {
        return balance;
    }

    public void displayInfo() {
        System.out.println("계좌번호: " + accountNumber);
        System.out.println("소유자: " + owner);
        System.out.println("잔액: " + balance + "원");
    }
}
