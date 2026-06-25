package oopexam.dip;

public class TVUser {
    public static void main(String[] args) {
//        CaramiTv tv = new CaramiTv();
//        tv.powerOn();
//        tv.volumeUp();
//        tv.volumeUp();
//        tv.volumeUp();
//        tv.volumeDown();
//        tv.volumeDown();
//        tv.powerOff();

        STV tv = new STV();

        tv.on();
        tv.volumeUp();
        tv.volumeUp();
        tv.volumeUp();
        tv.volumeDown();
        tv.volumeDown();
        tv.off();

//        TV tv = new TV();
//
//        tv.on();
//        tv.volumeUp();
//        tv.volumeUp();
//        tv.volumeUp();
//        tv.volumeDown();
//        tv.volumeDown();
//        tv.off();

    }
}
