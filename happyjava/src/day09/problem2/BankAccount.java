package day09.problem2;

public class BankAccount {
    private String accountNumber;
    private String owner;
    private double balance;
    private static int totalAccounts = 0;

    public BankAccount(String accountNumber, String owner) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = 0;
        totalAccounts++;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("입금 금액은 0보다 커야 합니다.");
            return false;
        }
        balance += amount;
        System.out.println(amount + "원이 입금되었습니다.");
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("출금 금액은 0보다 커야 합니다.");
            return false;
        }
        if (amount > balance) {
            System.out.println("잔액이 부족합니다.");
            return false;
        }
        balance -= amount;
        System.out.println(amount + "원이 출금되었습니다.");
        return true;
    }

    public boolean transfer(BankAccount target, double amount) {
        if (target == null) {
            System.out.println("이체할 계좌가 없습니다.");
            return false;
        }
        if (amount <= 0) {
            System.out.println("이체 금액은 0보다 커야 합니다.");
            return false;
        }
        if (amount > balance) {
            System.out.println("잔액이 부족합니다.");
            return false;
        }

        this.balance -= amount;
        target.balance += amount;
        System.out.println(amount + "원이 " + target.owner + "님 계좌로 이체되었습니다.");
        return true;
    }

    public void showBalance() {
        System.out.println("잔액: " + balance + "원");
    }

    public void showAccountInfo() {
        System.out.println("계좌번호: " + accountNumber);
        System.out.println("예금주: " + owner);
        System.out.println("잔액: " + balance + "원");
    }

    public static void showTotalAccounts() {
        System.out.println("전체 계좌 수: " + totalAccounts);
    }
}
