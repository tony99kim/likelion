package day08;

public class Chess extends Game{
    @Override
    void initalize() {
        System.out.println("체스 게임을 초기화합니다.");
        System.out.println("체스 게임을 배치합니다.");
    }

    @Override
    void startPlay() {
        System.out.println("체스 게임을 시작합니다.");
        System.out.println("흰색이 먼저 움직입니다.");
    }

    @Override
    void endPlay() {
        System.out.println("체크메이트! 게임 종료.");
    }
}
