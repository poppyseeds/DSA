package RandomQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.OptionalDouble;

public class MeanMedianMode {

    public static void main(String[] args) {
        int[] array = {2,4,15,5,5,33,1,5,5,5,5,5,5};
        function(array);
    }

    public static void function(int[] array){
        //mean
        double sum = 0;
        for(int num : array) sum += num;
        double mean = sum/array.length;

        //median
        Arrays.sort(array);
        double median;
        if(array.length % 2 == 0){
            median = (double) (array[array.length / 2 - 1] + array[array.length / 2]) /2;
        }
        else{
            median = array[array.length/2];
        }
        //mode
        int mode = mode(array);

        System.out.printf("Mean: %.6f\n", mean);
        System.out.printf("Median: %.6f\n", median);
        System.out.printf("Mode: "+ mode);
    }

    private static int mode(int[] arr) {
        int mode = arr[0];
        int maxCount = 0;

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mode = arr[i];
            }
        }
        return mode;
    }


}
