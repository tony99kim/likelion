package builderexam.builderuser;

public class UserMain {
    public static void main(String[] args) {
        User kim = new User.Builder()
                .name("김태엽")
                .age(28)
                .email("kim@naver.com")
                .address("seoul")
                .build();

        System.out.println(kim);
        User taeyeop = new User.Builder()
                .address("서울시 마포구")
                .age(10)
                .build();

        System.out.println(taeyeop);

        User taeyeop2 = new User.Builder()
                .name("태엽")
                .age(10)
                .email("taeyeop@naver.com")
                .address("서울시 마포구")
                .build();

        System.out.println(taeyeop2);
    }
}
