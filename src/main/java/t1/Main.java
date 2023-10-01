package t1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Дан List ‹String› names. Удалите первую букву из каждого имени и верните отсортированный список.
 */
public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Иван", "Марья", "Рошан"));
        Function<String, String> binaryOperator = e -> e.substring(1);

        ListIterator<String> stringListIterator = list.listIterator();
        while (stringListIterator.hasNext()) {
            stringListIterator.set(binaryOperator.apply(stringListIterator.next()));
        }
        list.sort(Comparator.naturalOrder());
        System.out.println(list);

        /////////////////////
        list = new ArrayList<>(List.of("Иван", "Марья", "Рошан"));
        list = list.stream().map(binaryOperator).collect(Collectors.toList());
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
        /////////////////////
        list = new ArrayList<>(List.of("Иван", "Марья", "Рошан"));
        list.replaceAll(e -> e = e.substring(1));
        list.sort(Comparator.naturalOrder());
        System.out.println(list);


    }
}
