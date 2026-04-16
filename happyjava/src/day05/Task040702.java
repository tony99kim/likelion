package day05;

public class Task040702 {
    public static void main(String[] args) {
        double[] doubles = {1.5, 3.7, 2.4, 9.8, 7.6, 3.4};

        double max = doubles[0];
        double min = doubles[0];


        for(int i = 0; i < doubles.length; i++){
            if(doubles[i] > max){
                max = doubles[i];
            }
            if(doubles[i] < min){
                min = doubles[i];
            }
        }
        System.out.println("Max: " + max + ", Min: " + min);
    }
}
