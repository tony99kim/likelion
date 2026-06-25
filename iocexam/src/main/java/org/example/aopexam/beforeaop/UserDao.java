package org.example.aopexam.beforeaop;

public class UserDao {
    LogBean logBean = new LogBean();
    TranssactionBean transsactionBean = new TranssactionBean();
    public void addUser() {

//      로그를 위한 코드
//      System.out.println("로그를 남깁니다");
        logBean.logging();

//      트랙잭션 처리를 위한 코드
//        System.out.println("트랜잭션 코드 추가");
        transsactionBean.startTransaction();

//      보안 관련 코드 추가
        System.out.println("보안 코드 추가");


        System.out.println("User를 추가하기 위한 코드1");
        System.out.println("User를 추가하기 위한 코드2");
        System.out.println("User를 추가하기 위한 코드3");
        System.out.println("User를 추가하기 위한 코드4");
        System.out.println("User를 추가하기 위한 코드5");

//        System.out.println("트랜잭션 코드 추가");
        transsactionBean.endTransaction();
    }

    public void updateUser(){

        logBean.logging();
        transsactionBean.startTransaction();

        System.out.println("User를 수정하기 위한 코드1");
        System.out.println("User를 수정하기 위한 코드2");
        System.out.println("User를 수정하기 위한 코드3");
        System.out.println("User를 수정하기 위한 코드4");
        System.out.println("User를 수정하기 위한 코드5");

        transsactionBean.endTransaction();
    }
}
