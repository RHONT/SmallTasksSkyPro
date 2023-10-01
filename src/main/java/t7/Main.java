package t7;

/**
 * Напишите пример перехвата и обработки исключения в блоке try-catch метода.
 */
public class Main {
    public static void main(String[] args) {
        int[] arr=new int[2];

        try {
            arr[6]=10;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Выход за пределы диапазона");
        }
    }
}
