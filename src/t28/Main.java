package t28;
/**
 * Написать программу на Java для вычисления серии чисел Фибоначчи.
 */

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //Объявляем переменные при известных первых двух:
        int num0 = 0;
        int num1 = 1;
        int num2;
        //Первые две переменные выводим вне цикла:
        System.out.print(num0 + " " + num1 + " ");
        for (int i = 3; i <= 11; i++) {
            num2 = num0 + num1;
            //Каждый следующий элемент выводим в цикле:
            System.out.print(num2 + " ");
            //Предыдущим двум переменным присваиваем новые значения:
            num0 = num1;
            num1 = num2;
        }
        System.out.println();

        ///////////////////////////////////

        Stream.iterate(new int[]{0, 1}, arr -> new int[]{arr[1], arr[0]+ arr[1]})

                //Задаём лимит значений:
                .limit(11)

                //Отбираем по первому элементу каждого массива:
                .map(y -> y[0])

                //Выводим в консоль:
                .forEach(e->System.out.print(e + " "));

    }

}
