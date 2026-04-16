package day05;

import java.util.Arrays;

public class ArrayCopyExample {
    public static void main(String[] args) {

        int[] originalArr = {1,2,3,4,5,6,7,8,9,10};

        int[] copyArr = new int[originalArr.length];
        for(int i=0;i<originalArr.length;i++){
            copyArr[i] = originalArr[i]; // 깊은복사 (값을 복사함)
        }
        System.out.println(Arrays.toString(copyArr));

        int[] copy2 = originalArr;  //얕은 복사 (주소값만 복사)

        System.out.println(Arrays.toString(copy2));
    }
}
