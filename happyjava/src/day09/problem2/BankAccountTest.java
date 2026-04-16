package day09.task2;

class BankAccount {
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

public class BankAccountTest {
    public static void main(String[] args) {
        System.out.println("===== 은행 계좌 시스템 테스트 =====\n");

        // 계좌 생성
        BankAccount account1 = new BankAccount("123-456-789", "김은행");
        BankAccount account2 = new BankAccount("987-654-321", "이저축");

        // 전체 계좌 수 확인
        BankAccount.showTotalAccounts();
        System.out.println();

        // 입금 테스트
        account1.deposit(50000);
        account1.deposit(-1000); // 잘못된 금액
        account2.deposit(30000);
        System.out.println();

        // 출금 테스트
        account1.withdraw(20000);
        account1.withdraw(50000); // 잔액 부족
        System.out.println();

        // 계좌 이체 테스트
        account1.transfer(account2, 15000);
        account1.transfer(account2, 30000); // 잔액 부족
        System.out.println();

        // 계좌 정보 출력
        account1.showAccountInfo();
        account2.showAccountInfo();
    }
}
