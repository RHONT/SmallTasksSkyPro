package t13;
/**
 * Необходимо реализовать следующий метод:
 *
 * На вход получаем список названий книг.
 * Распределяем книги по полкам так, чтобы на каждой полке было примерно одинаковое количество книг.
 * Все книги должны быть отсортированы по алфавиту с первой до последней полки.
 * Количество полок константное — 5 штук.
 * Вернуть книги, распределенные по полкам.
 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] books = new String[]{"g", "a", "f", "s", "s", "d", "a", "u", "i", "i", "i", "i", "i", "i", "i", "i", "i"};
        Arrays.sort(books);
        int amountRows = 3;
        String[][] shelves;
        int limiter;

        int amountInOneRows = books.length / amountRows;
        int remains = books.length % amountRows;
        boolean expansion;

        if (remains == 0) {
            shelves = new String[amountRows][amountInOneRows];
            limiter = amountInOneRows - 1;
            expansion = false;
        } else {
            shelves = new String[amountRows][++amountInOneRows];
            limiter = amountInOneRows - 1;
            expansion = true;
        }


        int incrementRows = 0;
        int incrementBook = 0;
        int end=books.length;

        for (int i = 0; i < end; i++) {

            if (incrementBook > limiter) {
                incrementRows++;
                incrementBook = 0;

                if (expansion) {
                     remains--;
                    if (remains<=0) {
                        limiter--;
                        expansion = false;
                    }
                }
            }

            shelves[incrementRows][incrementBook++] = books[i];
        }

        for (var element : shelves) {
            System.out.println(Arrays.toString(element));
        }
    }
}
