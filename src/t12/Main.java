package t12;
/**
 * Дан массив пар названий книг и авторов, необходимо привести каждую пару в строку вида: "Название книги" И. О. Фамилия автора.
 */

import java.util.Arrays;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {

        UnaryOperator<String> convertFio = e -> {
            String[] result = e.split(" ");
            return result[1].charAt(0) + ". " + result[2].charAt(0) + ". " + result[0];
        };

        String[][] books = new String[][]{{"Преступление", "Гайдай Леонид Иванович"}, {"Жмурки", "Нестеров Генадий Петрович"}, {"Адепты темных сил", "Незнайкина Людима Анатольева"}};
        String[] result = new String[books.length];
        for (int i = 0; i < books.length; i++) {
            result[i] = "\"" + books[i][0] + "\"" + " " + convertFio.apply(books[i][1]);
        }

        System.out.println(Arrays.toString(result));

        System.out.println();

        Arrays.stream(result).forEach(System.out::println);
    }

}