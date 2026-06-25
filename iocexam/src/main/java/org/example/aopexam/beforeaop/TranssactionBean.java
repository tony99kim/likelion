package org.example.aopexam.beforeaop;

public class TranssactionBean {
    public void startTransaction() {
        System.out.println("트랜잭션 시작");
    }

    public void endTransaction() {
        System.out.println("트랜잭션 종료");
    }
}
