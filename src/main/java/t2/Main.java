package t2;
/**
 * Напишите программу, которая переворачивает массив.
 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr={5,4,7,1,7};
        for (int i = 0; i < (arr.length/2); i++) {
            int temp=arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
