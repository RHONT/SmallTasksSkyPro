package t15;

import java.util.Arrays;

/**
 * Необходимо реализовать следующий метод:
 *
 * Получаем на входе массив чисел.
 * Все четные числа увеличиваем на единицу.
 * Возвращаем кусок списка с 3-го по 7-й элемент.
 */
public class Main {
    public static void main(String[] args) {

        int[] arr=new int[]{1,2,3,4,5,6,7,8,9,10};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%2==0) {
                arr[i]++;
            }
        }
        int[] result=new int[5];
        System.arraycopy(arr,3,result,0,5);
        System.out.println(Arrays.toString(result));

    }
}
