package t31;

/**
 * Напишите Java-программу, чтобы найти второе по величине число в массиве.
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 100, 55, 30};
        int max = Integer.MIN_VALUE;
        int preMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max) {
                preMax=max;
                max=arr[i];
            } else if (arr[i]>preMax) {
                preMax=arr[i];
            }
        }
        if (preMax==Integer.MIN_VALUE) {
            preMax=max;
        }

        System.out.println(preMax);

    }
}
