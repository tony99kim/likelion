package day05;

public class Task040705 {
    public static void main(String[] args) {
        int[] array1 = {1, 3, 5, 7, 9};
        int[] array2 = {0, 2, 4, 6, 8, 10, 3, 5};

        int[] union = new int[array1.length + array2.length];
        int index = 0;

        // 1. array1 먼저 넣기
        for (int i = 0; i < array1.length; i++) {
            union[index++] = array1[i];
        }

        // 2. array2 넣을 때 중복 체크
        for (int i = 0; i < array2.length; i++) {
            boolean isDuplicate = false;

            // 이미 union에 있는지 확인
            for (int j = 0; j < index; j++) {
                if (union[j] == array2[i]) {
                    isDuplicate = true;
                    break;
                }
            }

            // 중복 아니면 추가
            if (!isDuplicate) {
                union[index++] = array2[i];
            }
        }

        // 3. 결과 출력
        for (int i = 0; i < index; i++) {
            System.out.print(union[i] + " ");
        }
    }
}
