package t36;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

/**
 * Напишите программу, которая на вход получает массив чисел и на выход отдает сумму минимального и максимального значения массива.
 */
public class Main {


    public static void main(String[] args) {
        int[] arrInt={100,2,3,4,5,6,7,8};

        IntSummaryStatistics statistics = Arrays.stream(arrInt).summaryStatistics();
        int result= statistics.getMin()+statistics.getMax();
        System.out.println(result);
        ///////////////////

        Arrays.sort(arrInt);
        int result2=arrInt[0]+arrInt[arrInt.length-1];  // только если null нет в массиве
        System.out.println(result2);

        ////////////////

        int min=arrInt[0];
        int max=arrInt[0];
        for (int i = 0; i < arrInt.length; i++) {
            if (arrInt[i]>max) max=arrInt[i];
            if (arrInt[i]<min) min=arrInt[i];
        }
        int result3=min+max;
        System.out.println(result3);

    }
}
